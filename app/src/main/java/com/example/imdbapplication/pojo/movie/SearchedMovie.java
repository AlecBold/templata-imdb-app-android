package com.example.imdbapplication.pojo.movie;

import com.example.imdbapplication.pojo.movie.Movie;
import com.google.gson.annotations.SerializedName;

public class SearchedMovie extends Movie {

    @SerializedName("description")
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
