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

/**
 * Class that sorts dat data, and compiles them to array dateDataList.
 */
public class date_layout extends AppCompatActivity {

    public TextView paiva;
    static String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("fiilismittari", "jee p''stii t'nne");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_layout);
        ListView dayData = findViewById(R.id.dayData);


        Intent incomingIntent = getIntent();
        date = incomingIntent.getStringExtra(Paivakirja.DATE);
        paiva = findViewById(R.id.paivaView);
        paiva.setText(date);

//        sortByDate();

        try {
            dayData.setAdapter(new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    GlobalModel.getInstance().getMoodInts())
            );

        } catch (Exception exp) {
            Log.d("juu", String.valueOf(exp));
        }

    }

//    public void sortByDate() {
//        for(int i = 0; i < GlobalModel.getInstance().getDataPoints().size(); i++) {
//            Log.d("jiii", date);
//            Log.d("jii", GlobalModel.getInstance().getDataPoints().get(i).getDate());
//            if (GlobalModel.getInstance().getDataPoints().get(i).getDate().equals(date)) {
//                dayDataList.add(GlobalModel.getInstance().getDataPoints().get(i).getMood());
//            }
//        }
//    }
}
