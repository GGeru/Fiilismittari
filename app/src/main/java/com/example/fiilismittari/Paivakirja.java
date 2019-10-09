package com.example.fiilismittari;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//this is an activity

public class Paivakirja extends AppCompatActivity {
    int chosenRadioId;
    int savedMood;
    String currentDate;
    static final String MOODS = "moods";
//    ArrayList<DataPoint> dataPoints;
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
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity

        loadData();

        saveMood();

//        getAverageMood();

        dataView.setAdapter(new ArrayAdapter<DataPoint>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalModel.getInstance().getDataPoints())
        );



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
                GlobalModel.getInstance().addDataPoint(new DataPoint(1, currentDate));
                break;
            case R.id.notGoodMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(2, currentDate));
                break;
            case R.id.okMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(3, currentDate));
                break;
            case R.id.niceMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(4, currentDate));
                break;
            case R.id.greatMood:
                GlobalModel.getInstance().addDataPoint(new DataPoint(5, currentDate));
                break;
        }
        saveData();
    }

    /**
     * Counts the average mood from the datapoints saved in the ArrayList dataPoints.
     */
//    public void getAverageMood() {
//        int currentCount = 0;
//        for (int i = 0; i < dataPoints.size(); i++) {
//            currentCount += dataPoints.get(i).getMood();
//        }
//
//        double average = (double) currentCount / dataPoints.size();
//        test.setText(Double.toString(average));
//        Log.d("Fiilismittari", "jee " + Integer.toString(dataPoints.size()));
//    }

    /**
     * Converts the dataPoints list into a Json string, and then saves the list into
     * shared preferences.
     */
    public void saveData() {
        SharedPreferences prefPut = getSharedPreferences(MOODS, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        Gson gson = new Gson();
        String json = gson.toJson(GlobalModel.getInstance().getDataPoints());
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


}

