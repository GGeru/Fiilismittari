package com.example.fiilismittari;

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
    private String currentDate;

    static GlobalModel getInstance() {
        return ourInstance;
    }

    /**
     *  For formatting the date to DAY/ MONTH /YEAR
     */
    private GlobalModel() {
        Calendar calendar = Calendar.getInstance(); //https://www.youtube.com/watch?v=Le47R9H3qow
        currentDate = calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.MONTH) + "/" + calendar.get(calendar.YEAR);
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
