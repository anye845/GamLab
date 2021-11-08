package com.example.gamlab.database;

public class schedule {

    private String time;
    private String date;
    public schedule(){}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public schedule(String time, String date) {
        this.time = time;
        this.date = date;
    }
}
