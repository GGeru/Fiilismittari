package com.example.fiilismittari;
//datapoint will have the mood and date
//Creator @ALeksi Knuuttila
/**
 * Class with the  parameters mood and date
 */
public class DataPoint {
    private double mood;
    private String date;

    public DataPoint(double mood, String date) {
        this.mood = mood;
        this.date = date;
    }

    /**
     * Method for returning mood
     * @return
     */
    public double getMood() {
        return mood;
    }

    /**
     * Method for returning date
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * toString method with text "Mieliala: " + mood + " Päivämäärä: " + date
     * @return
     */
    public  String toString() {
        String toReturn = "Mieliala: " + mood + " Päivämäärä: " + date;
        return toReturn;
    }
}

/*


 */


