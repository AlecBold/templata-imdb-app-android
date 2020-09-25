package com.example.imdbapplication.pojo.casts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListActorCast {
    @SerializedName("actors")
    private List<ActorCast> actors;

    public List<ActorCast> getActors() {
        return actors;
    }

    public void setActors(List<ActorCast> actors) {
        this.actors = actors;
    }
}
