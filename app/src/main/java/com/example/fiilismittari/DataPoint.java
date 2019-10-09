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

    public String getDate() {
        return date;
    }

    public  String toString() {
        String toReturn = "Mieliala: " + mood + " Päivämäärä: " + date;
        return toReturn;
    }
}

/*


 */


