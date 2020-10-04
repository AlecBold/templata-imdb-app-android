package com.example.imdbapplication.pojo.movie;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.imdbapplication.pojo.IMDbObject;
import com.google.gson.annotations.SerializedName;

public class Movie extends IMDbObject {
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String imgUrl;
    @SerializedName("year")
    private String year;
    @SerializedName("imDbRating")
    private String imDbRating;
    @SerializedName("role")
    private String role;
    @SerializedName("releaseState")
    private String release;
    @SerializedName("runtimeStr")
    private String runtime;
    @SerializedName("contentRating")
    private String contentRating;
    @SerializedName("weekend")
    private String weekend;
    @SerializedName("gross")
    private String gross;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

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
