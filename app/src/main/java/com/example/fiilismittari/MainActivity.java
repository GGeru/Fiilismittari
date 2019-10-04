package com.example.fiilismittari;
// joku kommentti vaan
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    Intent paivakirjaIntent; //mainIntent is the intent that will be executed when profile is set
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
        paivakirjaIntent = new Intent(this, Paivakirja.class);
        paivakirjaIntent.putExtra("checkedRadioButton", radioId); //attach the checked radio button id to the intent
        startActivity(paivakirjaIntent); //start the next activity
    }
}
