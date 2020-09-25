package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

public class Trailer extends IMDbObject {
    @SerializedName("link")
    private String videoUrl;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
