package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//this is an activity

public class Paivakirja extends AppCompatActivity {

    RadioGroup radioGroup;
    int chosenRadioId;
    Intent profileIntent;
    int savedMood;
    String currentDate;
    TextView testi;
    ArrayList<DataPoint> dataPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        radioGroup = findViewById(R.id.radioGroup);

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity
        testi = findViewById(R.id.textView2); // just some test code to see if the radiobutton id comes through

        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
//        testi.setText(currentDate);
        saveMood();
        getAverageMood();
    }

    public void onTestButtonClick(View v) { //this button takes you to profile activity
        profileIntent = new Intent(this, ProfileActivity_1.class);
        startActivity(profileIntent);
    }

    public void saveMood() { //put the chosen mood in the globalmodel for saving
        switch (chosenRadioId) {
            case R.id.badMood:
                GlobalModel.getInstance().getDataPoints().add(new DataPoint(1, currentDate)); //GlobalModel is a  singleton, check lecture 6
                break;
            case R.id.notGoodMood:
                GlobalModel.getInstance().getDataPoints().add(new DataPoint(2, currentDate));
                break;
            case R.id.okMood:
                GlobalModel.getInstance().getDataPoints().add(new DataPoint(3, currentDate));
                break;
            case R.id.niceMood:
                GlobalModel.getInstance().getDataPoints().add(new DataPoint(4, currentDate));
                break;
            case R.id.greatMood:
                GlobalModel.getInstance().getDataPoints().add(new DataPoint(5, currentDate));
                break;
        }
    }

    public void getAverageMood() { //count the average mood from the datapoints collected
        dataPoints = GlobalModel.getInstance().getDataPoints(); //get the list of datapoints from GlobalModel
        double moodSum = 0;
        int i;
        for (i = 0; i < dataPoints.size(); i++) {
            double thisMood = (double) dataPoints.get(i).getMood();
            moodSum += thisMood;
        }

        double average = (double) moodSum / dataPoints.size();
        testi.setText(Double.toString(average));


    }

    @Override
    protected void onPause() {
        super.onPause();
        //make shared preferences, as in make a place where we save stuff
        SharedPreferences prefPut = getSharedPreferences( "MyTestPref", Activity.MODE_PRIVATE);
        //i have no friking idea
        SharedPreferences.Editor prefEditor = prefPut.edit();
        //objectserializer is a class that separates things in the dataPoints arraylist
        try {
            prefEditor.putString("moods", ObjectSerializer.serialize(dataPoints));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
