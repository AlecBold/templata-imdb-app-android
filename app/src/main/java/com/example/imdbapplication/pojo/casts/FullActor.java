package com.example.imdbapplication.pojo.casts;

import com.example.imdbapplication.pojo.movie.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullActor extends Actor {
    @SerializedName("birthDate")
    private String birthDate;
    @SerializedName("deathDate")
    private String deathDate;
    @SerializedName("summary")
    private String description;
    @SerializedName("role")
    private String role;
    @SerializedName("awards")
    private String awards;
    @SerializedName("knownFors")
    private List<Movie> knownForMovies;
    @SerializedName("castMovies")
    private List<Movie> castMovies;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public List<Movie> getKnownForMovies() {
        return knownForMovies;
    }

    public void setKnownForMovies(List<Movie> knownForMovies) {
        this.knownForMovies = knownForMovies;
    }

    public List<Movie> getCastMovies() {
        return castMovies;
    }

    public void setCastMovies(List<Movie> castMovies) {
        this.castMovies = castMovies;
    }
}
