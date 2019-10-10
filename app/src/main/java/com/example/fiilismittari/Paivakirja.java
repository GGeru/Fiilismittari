package com.example.fiilismittari;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;

//this is an activity



public class Paivakirja extends AppCompatActivity {
    int chosenRadioId;
    int savedMood;
    String currentDate;
    static final String MOODS = "moods";
    static final String DATE = "moods";
    RadioGroup radioGroup;
    TextView test;
    Intent profileIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        radioGroup = findViewById(R.id.radioGroup);
        ListView dataView = findViewById(R.id.datapointsView);
        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.MONTH) + "/" + calendar.get(calendar.YEAR);

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity

        loadData();

        saveMood();

        getAverageMood();

        dataView.setAdapter(new ArrayAdapter<DataPoint>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalModel.getInstance().getDataPoints())
        );

        CalendarView mCalendarView;
        mCalendarView = findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date1 = dayOfMonth + "/ "+ (month+1) +"/ "+ year;
                Intent intent = new Intent(Paivakirja.this, date_layout.class) ;
                intent.putExtra(DATE, date1);
                Log.d("Fiilismittari", "jee menn''n intenttiin");
                startActivity(intent);
            }
        });
    }

    public void onTestButtonClick(View v) { //this button takes you to profile activity
        profileIntent = new Intent(this, ProfileActivity_1.class);
        startActivity(profileIntent);
    }

    /**
     * Saves the mood the user chose in the main activity, along with the corresponding
     * date to the ArrayList dataPoints
     */
    public void saveMood() { //put the chosen mood in the globalmodel for saving
        switch (chosenRadioId) {
            case R.id.badMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(1, GlobalModel.getInstance().getCurrentDate()));
                break;
            case R.id.notGoodMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(2, GlobalModel.getInstance().getCurrentDate()));
                break;
            case R.id.okMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(3, GlobalModel.getInstance().getCurrentDate()));
                break;
            case R.id.niceMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(4, GlobalModel.getInstance().getCurrentDate()));
                break;
            case R.id.greatMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(5, GlobalModel.getInstance().getCurrentDate()));
                break;
        }
        saveData();
    }

    /**
     * Counts the average mood from the datapoints saved in the ArrayList dataPoints.
     */
    public void getAverageMood() {
        ArrayList<DataPoint> dataPoints = GlobalModel.getInstance().getDataPoints();
        int currentCount = 0;
        for (int i = 0; i < dataPoints.size(); i++) {
            currentCount += GlobalModel.getInstance().getDataPoints().get(i).getMood();
        }

        double average = (double) currentCount / GlobalModel.getInstance().getDataPoints().size();
        test = findViewById(R.id.test);
        test.setText(Double.toString(average));
        Log.d("Fiilismittari", "jee " + Integer.toString(dataPoints.size()));
    }

    /**
     * Converts the dataPoints list into a Json string, and then saves the list into
     * shared preferences.
     */
    public void saveData() {
        SharedPreferences prefPut = getSharedPreferences(MOODS, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        Gson gson = new Gson();
        ArrayList<DataPoint> dataPoints = GlobalModel.getInstance().getDataPoints();
        String json = gson.toJson(dataPoints);
        prefEditor.putString(MOODS, json);
        prefEditor.apply();
    }

    /**
     * Loads the data from shared preferences, and converts the Json string back to Gson.
     */
    public void loadData() {

        SharedPreferences prefPut = getSharedPreferences(MOODS, Activity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefPut.getString(MOODS, null);
        Type type = new TypeToken<ArrayList<DataPoint>>() {}.getType();
        ArrayList<DataPoint> dataPoints= gson.fromJson(json, type);
        GlobalModel.getInstance().setMoods(dataPoints);

        Log.d("Fiilismittari", "jee loaddata toimi");
    }

    //https://www.youtube.com/watch?v=hHjFIG0TtA0 were reference to calendar


}

