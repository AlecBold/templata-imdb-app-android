package com.example.imdbapplication.pojo.movie;

import com.example.imdbapplication.pojo.movie.Movie;
import com.google.gson.annotations.SerializedName;

public class TopMovie extends Movie {
    @SerializedName("year")
    private String year;
    @SerializedName("imDbRating")
    private String imDbRating;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

}
