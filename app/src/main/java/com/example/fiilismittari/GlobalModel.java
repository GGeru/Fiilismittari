package com.example.fiilismittari;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 */
class  GlobalModel { //GlobalModel is a Singleton, lesson 6 slide show. we will use this to save the mood data (or not because it was hard :( )
    private static final GlobalModel ourInstance = new GlobalModel();
    private ArrayList<DataPoint> moods;
    private String currentDate;

    static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        moods = new ArrayList<>();
    }

    public void setDataPoints(ArrayList<DataPoint> dataa) {
        moods = dataa;
    }

    public ArrayList<DataPoint> getDataPoints() {
        return moods;
    }
}
