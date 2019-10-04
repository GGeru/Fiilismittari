package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    Intent mainIntent; //mainIntent is the intent that will be executed when profile is set
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup = findViewById(R.id.radioGroup);

    }

    public void checkRadioButton(View v) { //check which radiobutton is selected
        radioId = radiogroup.getCheckedRadioButtonId();

    }

    public void chooseButtonPress(View v) { //onClick method for "valitse" -button
        mainIntent = new Intent(this, Paivakirja.class);
        mainIntent.putExtra("checkedRadioButton", radioId); //take the info of the checked button to the next activity
        startActivity(mainIntent); //start the next activity

    }
}
