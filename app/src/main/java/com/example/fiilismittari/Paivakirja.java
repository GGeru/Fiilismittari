package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

//this is an activity

public class Paivakirja extends AppCompatActivity {
    RadioGroup radioGroup;
    int chosenRadioId;
    int savedMood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        radioGroup = findViewById(R.id.radioGroup);

        Intent paivakirjaIntent = getIntent(); //get the intent that started this activity
        chosenRadioId = paivakirjaIntent.getIntExtra(MainActivity.CHECKED_BUTTON, 0); //the chosen radiobutton id in the main activity
        TextView testi = findViewById(R.id.textView2); // just some test code to see if the radiobutton id comes through
        testi.setText(Integer.toString(chosenRadioId));
        saveMood();


    }

    private void saveMood() { //kesken!
        switch (chosenRadioId) {
            case R.id.badMood:

                break;
            case R.id.notGoodMood:

                break;
            case R.id.okMood:

                break;
            case R.id.niceMood:

                break;
            case R.id.greatMood:

                break;
        }
    }
}
