package com.example.fiilismittari;
// joku kommentti vaan
// parempi kommentti
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

/**
 * This MainActivity is where you choose your current mood from 5 different pictures
 */
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

    /**
     * This is the onClick method for the mood radioGroup
     * @param v
     */
    public void onRadioSelected(View v) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup); //find us the radiogroup
        radioId = radiogroup.getCheckedRadioButtonId();
    }

    /**
     * This is the onClick method for the "valitse" button seen on the main screen.
     * This onClick method will also attach the chosen radiobutton id to a new intent
     * and start the Paivakirja activity.
     * @param v
     */
    public void chooseButtonPress(View v) {
        Log.d("Fiilismittari", "jee p''stiin intenttiin");
        Log.d("Fillismittari", "button pressed");
        paivakirjaIntent = new Intent(this, Paivakirja.class);
        paivakirjaIntent.putExtra(CHECKED_BUTTON, radioId); //attach the checked radio button id to the intent
        Log.d("Fiilismittari", "jee p''stiin intenttiin");
        startActivity(paivakirjaIntent); //start the next activity

    }
}
