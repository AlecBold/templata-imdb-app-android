package com.example.imdbapplication.pojo.casts;

import com.example.imdbapplication.pojo.casts.Actor;
import com.google.gson.annotations.SerializedName;

public class ActorCast extends Actor {
    @SerializedName("asCharacter")
    private String character;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
