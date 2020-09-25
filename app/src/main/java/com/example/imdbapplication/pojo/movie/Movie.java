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

}
