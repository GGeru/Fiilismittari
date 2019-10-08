package com.example.fiilismittari;
// joku kommentti vaan
// parempi kommentti
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String CHECKED_BUTTON = "com.example.fiilismittari.INT";
    RadioGroup radiogroup;
    Intent paivakirjaIntent; //paivakirjaIntent is the intent that will be executed when profile is set
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup = findViewById(R.id.radioGroup);

    }

    public void onRadioSelected(View v) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup); //find us the radiogroup
        switch (radiogroup.getCheckedRadioButtonId()) {
            case R.id.badMood:
                checkRadioButton();
                break;
            case R.id.notGoodMood:
                checkRadioButton();
                break;
            case R.id.okMood:
                checkRadioButton();
                break;
            case R.id.niceMood:
                checkRadioButton();
                break;
            case R.id.greatMood:
                checkRadioButton();
                break;
        }
    }

    public void checkRadioButton() { //check which radiobutton is selected
        radioId = radiogroup.getCheckedRadioButtonId(); //get the id of the checked button
    }

    public void chooseButtonPress(View v) { //onClick method for "valitse" -button
        /* In here we will insert a code block that checks if a textview "name" or something
        * in ProfileActivity is empty. If it is empty, open profile activity and if it is not, open
        * Paivakirja(activity). */
        Log.d("Fillismittari", "button pressed");
        paivakirjaIntent = new Intent(this, Paivakirja.class);
        paivakirjaIntent.putExtra(CHECKED_BUTTON, radioId); //attach the checked radio button id to the intent
        startActivity(paivakirjaIntent); //start the next activity

    }
}
