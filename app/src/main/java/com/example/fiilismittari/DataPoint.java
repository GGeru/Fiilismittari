package com.example.fiilismittari;
//datapoint will have the mood and date
public class DataPoint {
    private int mood;
    private String date;

    public DataPoint(int mood, String date) {
        this.mood = mood;
        this.date = date;
    }

    public int getMood() {
        return mood;
    }
}
