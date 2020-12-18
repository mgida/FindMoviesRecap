package com.example.findmoviesrecap.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("original_title")
    private String name;
    @SerializedName("release_date")
    private String date;
    @SerializedName("vote_average")
    private String rate;

    public Movie(String name, String date, String rate) {
        this.name = name;
        this.date = date;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
