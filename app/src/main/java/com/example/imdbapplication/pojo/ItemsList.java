package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsList<T> {
    @SerializedName("items")
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
