package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

public class IMDbObject {
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
