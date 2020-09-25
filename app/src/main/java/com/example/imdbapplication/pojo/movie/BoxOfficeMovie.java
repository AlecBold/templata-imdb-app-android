package com.example.imdbapplication.pojo.movie;

import com.google.gson.annotations.SerializedName;

public class BoxOfficeMovie extends Movie {
    @SerializedName("weekend")
    private String weekend;
    @SerializedName("gross")
    private String gross;

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }
}
