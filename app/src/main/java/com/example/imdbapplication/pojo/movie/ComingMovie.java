package com.example.imdbapplication.pojo.movie;

import com.google.gson.annotations.SerializedName;

public class ComingMovie extends Movie {
    @SerializedName("year")
    private String year;
    @SerializedName("releaseState")
    private String release;
    @SerializedName("runtimeStr")
    private String runtime;
    @SerializedName("contentRating")
    private String contentRating;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
