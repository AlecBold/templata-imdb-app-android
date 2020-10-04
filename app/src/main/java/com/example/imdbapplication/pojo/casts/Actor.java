package com.example.imdbapplication.pojo.casts;

import com.example.imdbapplication.pojo.IMDbObject;
import com.google.gson.annotations.SerializedName;

public class Actor extends IMDbObject {
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String urlImage;
    @SerializedName("asCharacter")
    private String character;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
