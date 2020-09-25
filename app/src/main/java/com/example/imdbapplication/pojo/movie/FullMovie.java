package com.example.imdbapplication.pojo.movie;

import com.example.imdbapplication.pojo.Image;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.Trailer;
import com.example.imdbapplication.pojo.casts.ActorCast;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullMovie extends Movie {
    @SerializedName("releaseDate")
    private String release;
    @SerializedName("plot")
    private String plot;
    @SerializedName("directors")
    private String directors;
    @SerializedName("writers")
    private String writers;
    @SerializedName("actorList")
    private List<ActorCast> actors;
    @SerializedName("genres")
    private String genres;
    @SerializedName("images")
    private ItemsList<Image> images;
    @SerializedName("similars")
    private List<TopMovie> similarMovies;
    @SerializedName("imDbRating")
    private String rating;
    @SerializedName("contentRating")
    private String contentRating;
    @SerializedName("runtimeStr")
    private String runtime;
    @SerializedName("year")
    private String year;
    @SerializedName("trailer")
    private Trailer trailer;

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<TopMovie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(List<TopMovie> similarMovies) {
        this.similarMovies = similarMovies;
    }

    public ItemsList<Image> getImages() {
        return images;
    }

    public void setImages(ItemsList<Image> images) {
        this.images = images;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public List<ActorCast> getActors() {
        return actors;
    }

    public void setActors(List<ActorCast> actors) {
        this.actors = actors;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
