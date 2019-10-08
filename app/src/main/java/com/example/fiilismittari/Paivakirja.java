package com.example.fiilismittari;
import java.text.SimpleDateFormat;
import java.util.Calendar
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Paivakirja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);

        Intent mainIntent = getIntent(); //get th intent that started this activity

    }

    Date currentTime = Calendar.getInstance().getTime();

    //String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

}
    Bundle b = getIntent().getExtras();
    int i = b.getInt(MainActivity.EXTRA, 0);

((TextView)findViewById(R.id.Date))
        .setText(GlobalModel.getInstance().getDate(i).getVaihtoehto());
        ((TextView)findViewById(R.id.vaihtoehto))
        .setText(GlobalModel.getInstance().getDate(i).getVaihtoehto());
