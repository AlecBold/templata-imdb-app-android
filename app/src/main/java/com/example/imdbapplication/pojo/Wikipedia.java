package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

public class Wikipedia {
    @SerializedName("url")
    private String wikiUrl;

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }
}
