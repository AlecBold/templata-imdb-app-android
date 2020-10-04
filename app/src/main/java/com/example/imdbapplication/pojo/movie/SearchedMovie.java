package com.example.imdbapplication.pojo.movie;

import com.example.imdbapplication.pojo.IMDbObject;
import com.example.imdbapplication.pojo.movie.Movie;
import com.google.gson.annotations.SerializedName;

public class SearchedMovie extends IMDbObject {
    @SerializedName("image")
    private String imgUrl;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
