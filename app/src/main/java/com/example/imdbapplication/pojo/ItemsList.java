package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsList<T> {
    @SerializedName("items")
    private List<T> items;
    @SerializedName("errorMessage")
    private String errorMessage;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
