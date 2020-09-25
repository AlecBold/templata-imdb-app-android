package com.example.imdbapplication.pojo.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListSimilarMovie {
    @SerializedName("similars")
    private List<TopMovie> similarMovies;

    public List<TopMovie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(List<TopMovie> similarMovies) {
        this.similarMovies = similarMovies;
    }
}
