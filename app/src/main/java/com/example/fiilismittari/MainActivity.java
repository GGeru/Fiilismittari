package com.example.fiilismittari;
// joku kommentti vaan
// parempi kommentti
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String CHECKED_BUTTON = "com.example.fiilismittari.MESSAGE";
    RadioGroup radiogroup;
    Intent paivakirjaIntent; //paivakirjaIntent is the intent that will be executed when profile is set
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup = findViewById(R.id.radioGroup);

    }

    public void checkRadioButton(View v) { //check which radiobutton is selected
        radioId = radiogroup.getCheckedRadioButtonId(); //get the id of the checked button

    }

    public void chooseButtonPress(View v) { //onClick method for "valitse" -button
        /* In here we will insert a code block that checks if a textview "name" or something
        * in ProfileActivity is empty. If it is empty, open profile activity and if it is not, open
        * Paivakirja(activity). */
        paivakirjaIntent = new Intent(this, Paivakirja.class);
        paivakirjaIntent.putExtra(CHECKED_BUTTON, radioId); //attach the checked radio button id to the intent
        startActivity(paivakirjaIntent); //start the next activity
    }
}
