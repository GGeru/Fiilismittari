package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  Class that setups the date layout.
 */
public class date_layout extends AppCompatActivity {

    private TextView p_iv;

    public date_layout(TextView p_iv) {
        this.p_iv = p_iv;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_layout);


        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        p_iv.setText(date);



    }
}
