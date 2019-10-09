package com.example.fiilismittari;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class date_layout extends AppCompatActivity {

    public TextView paiva;
    String date;
    ArrayList dayDataList;


//
////    public date_layout(TextView p_iv) {
////        this.p_iv = p_iv;
////    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("fiilismittari", "jee p''stii t'nne");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_layout);
        ListView dayData = findViewById(R.id.dayData);


        Intent incomingIntent = getIntent();
        date = incomingIntent.getStringExtra(Paivakirja.DATE);
        paiva = findViewById(R.id.paivaView);
        paiva.setText(GlobalModel.getInstance().getDataPoints().get(50).getDate());

//        sortByDate();
//
//        try {
//            dayData.setAdapter(new ArrayAdapter<String>(
//                    this,
//                    android.R.layout.simple_list_item_1,
//                    dayDataList)
//            );
//        } catch (Exception exp) {
//            Log.d("juu", String.valueOf(exp));
//        }



    }

    public void sortByDate() {
        for(int i = 0; i < GlobalModel.getInstance().getDataPoints().size(); i++) {
            if (GlobalModel.getInstance().getDataPoints().get(i).getDate() == date) {
                dayDataList.add(GlobalModel.getInstance().getDataPoints().get(i).getMood());
            }
        }
    }
}
