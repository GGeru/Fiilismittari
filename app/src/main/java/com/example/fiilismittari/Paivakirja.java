package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Calendar;

//this is an activity

public class Paivakirja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);

        Intent paivakirjaIntent = getIntent(); //get th intent that started this activity
        String message = paivakirjaIntent.getStringExtra(MainActivity.CHECKED_BUTTON);


    }
}
