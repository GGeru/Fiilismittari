package com.example.fiilismittari;

import android.util.Log;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Singleton for saving mood data
 */
class  GlobalModel { //GlobalModel is a Singleton, lesson 6 slide show. we will use this to save the mood data (or not because it was hard :( )
    private static final GlobalModel ourInstance = new GlobalModel();
    private ArrayList<DataPoint> moodData;
    private ArrayList<String> moodInts;
    private String currentDate;

    static GlobalModel getInstance() {
        return ourInstance;
    }

    /**
     *  For formatting the date to DAY/ MONTH /YEAR
     */
    private GlobalModel() {
        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = calendar.get(calendar.DAY_OF_MONTH) + "/" + (calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR);
        moodData = new ArrayList<>();
    }

    /**
     * Method for collecting current date
     * @return
     */
    public String getCurrentDate() {
        return this.currentDate;
    }

    /**
     * Method for adding datapoints
     * @param data
     */
    public  void addDataPoint(DataPoint data) {
        moodData.add(data);
    }

    public ArrayList<String> getMoodInts() {
        moodInts = new ArrayList<>();
        for(int i = 0; i < GlobalModel.getInstance().getDataPoints().size(); i++) {
            Log.d("jiii", date_layout.date);
            Log.d("jii", GlobalModel.getInstance().getDataPoints().get(i).getDate());
            if (GlobalModel.getInstance().getDataPoints().get(i).getDate().equals(date_layout.date)) {

                moodInts.add(Double.toString(GlobalModel.getInstance().getDataPoints().get(i).getMood()));
            }
        }
        if(moodInts.isEmpty()) {
            moodInts.add("Ei merkintöjä tältä päivältä.");
        }

        return moodInts;
    }


    /**
     * Method for making a new list for datapoints
     * @param newList
     */
    public void setMoods(ArrayList<DataPoint> newList) {
        moodData = newList;
    }

    /**
     * Method for returning moods from datapoint array
     * @return
     */
    public ArrayList<DataPoint> getDataPoints() {
        return moodData;
    }

}
