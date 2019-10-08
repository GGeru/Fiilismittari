package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

//this is an activity

public class Paivakirja extends AppCompatActivity {
    RadioGroup radioGroup;
    int chosenRadioId;
    Intent profileIntent;
    int savedMood;
    String currentDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        radioGroup = findViewById(R.id.radioGroup);

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity
        TextView testi = findViewById(R.id.textView2); // just some test code to see if the radiobutton id comes through

        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        testi.setText(currentDate);
    }

    public void onTestButtonClick(View v) { //this button takes you to profile activity
        profileIntent = new Intent(this, ProfileActivity_1.class);
        startActivity(profileIntent);
    }

    private void saveMood() { //kesken!
        switch (chosenRadioId) {
            case R.id.badMood:
                GlobalModel.getInstance().getMoods().add(new DataPoint(1, currentDate)); //GlobalModel is a  singleton, check lecture 6 
                break;
            case R.id.notGoodMood:
                GlobalModel.getInstance().getMoods().add(new DataPoint(2, currentDate));
                break;
            case R.id.okMood:
                GlobalModel.getInstance().getMoods().add(new DataPoint(3, currentDate));
                break;
            case R.id.niceMood:
                GlobalModel.getInstance().getMoods().add(new DataPoint(4, currentDate));
                break;
            case R.id.greatMood:
                GlobalModel.getInstance().getMoods().add(new DataPoint(5, currentDate));
                break;
        }
    }
}
