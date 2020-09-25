package com.example.imdbapplication.pojo.casts;

import com.example.imdbapplication.pojo.ItemsList;
import com.google.gson.annotations.SerializedName;

public class FullCast <T> {
    @SerializedName("FullCast")
    private ItemsList<T> itemsCast;

    public ItemsList<T> getItemsCast() {
        return itemsCast;
    }

    public void setItemsCast(ItemsList<T> itemsCast) {
        this.itemsCast = itemsCast;
    }
}
