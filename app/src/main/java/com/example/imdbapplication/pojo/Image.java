package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("image")
    private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
