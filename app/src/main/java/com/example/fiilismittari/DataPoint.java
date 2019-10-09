package com.example.fiilismittari;
//datapoint will have the mood and date
public class DataPoint {
    private double mood;
    private String date;

    public DataPoint(double mood, String date) {
        this.mood = mood;
        this.date = date;
    }

    public double getMood() {
        return mood;
    }
}
