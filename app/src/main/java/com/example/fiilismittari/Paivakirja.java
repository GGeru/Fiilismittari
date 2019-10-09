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
    static ArrayList<DataPoint> dataPoints;
    RadioGroup radioGroup;
    TextView test;
    Intent profileIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        radioGroup = findViewById(R.id.radioGroup);
        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity
         test = findViewById(R.id.textView2); // just some test code to see if the radiobutton id comes through

        loadData();

        saveMood();

        getAverageMood();



        Bundle b = getIntent().getExtras();
        int i = b.getInt(MainActivity.EXTRA , 0);

        ((TextView)findViewById(R.id.textViewdatapoints))
                .setText(GlobalModel.getInstance().getDataPoints(i).getName());

        ListView lv = findViewById(R.id.text_View_dataPoints);

        lv.setAdapter(new ArrayAdapter<DataPoint>(
                this,
                android.R.layout.simple_list_item_1, //XML item layout
                // GlobalModel.getInstance().getdataPoints()) //array of data

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d(TAG, "onItemClick(" + i + ")");
                        Intent nextActivity = new Intent(Paivakirja.this, DataPoint.class);
                        nextActivity.putExtra(EXTRA, i);
                        startActivity(nextActivity);
                    }


                })
    ));


}


    public void onTestButtonClick(View v) { //this button takes you to profile activity
        profileIntent = new Intent(this, ProfileActivity_1.class);
        startActivity(profileIntent);
    }

    public void saveMood() { //put the chosen mood in the globalmodel for saving
        switch (chosenRadioId) {
            case R.id.badMood:
                dataPoints.add(new DataPoint(1, currentDate));
                break;
            case R.id.notGoodMood:
                dataPoints.add(new DataPoint(2, currentDate));
                break;
            case R.id.okMood:
                dataPoints.add(new DataPoint(3, currentDate));
                break;
            case R.id.niceMood:
                dataPoints.add(new DataPoint(4, currentDate));
                break;
            case R.id.greatMood:
                dataPoints.add(new DataPoint(5, currentDate));
                break;
        }

    }

    public void getAverageMood() {
        int currentCount = 0;
        for (int i = 0; i < dataPoints.size(); i++) {
            currentCount += dataPoints.get(i).getMood();
        }

        double average = (double) currentCount / dataPoints.size();
        test.setText(Double.toString(average));
        Log.d("Fiilismittari", "jee " + Integer.toString(dataPoints.size()));
    }

    public void saveData() {
        SharedPreferences prefPut = getSharedPreferences(MOODS, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dataPoints);
        prefEditor.putString(MOODS, json);
        prefEditor.apply();
    }

    public void loadData() {
        SharedPreferences prefPut = getSharedPreferences(MOODS, Activity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefPut.getString(MOODS, null);
        Type type = new TypeToken<ArrayList<DataPoint>>() {}.getType();
        dataPoints = gson.fromJson(json, type);
        if (dataPoints == null) {
            dataPoints = new ArrayList<>();
        }
        Log.d("Fiilismittari", "jee loaddata toimi");
    }
    @Override
    protected void onPause() {
        super.onPause();
        try {
            saveData();
            Log.d("Fiilismittari", "jee savedata toimi");
        } catch (Exception exception) {
            Log.d("Fiilismittari", "jee se ei toiminu :(");

        }
    }



}

