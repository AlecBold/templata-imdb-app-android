package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

public class IMDbObject {
    @SerializedName("id")
    private String id;
    @SerializedName("errorMessage")
    private String errorMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
