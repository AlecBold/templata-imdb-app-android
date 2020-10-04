package com.example.imdbapplication.pojo.movie;

import com.example.imdbapplication.pojo.IMDbObject;
import com.example.imdbapplication.pojo.Image;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.Trailer;
import com.example.imdbapplication.pojo.Wikipedia;
import com.example.imdbapplication.pojo.casts.Actor;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullMovie extends IMDbObject {
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String imgUrl;
    @SerializedName("year")
    private String year;
    @SerializedName("imDbRating")
    private String imDbRating;
    @SerializedName("releaseDate")
    private String release;
    @SerializedName("plot")
    private String plot;
    @SerializedName("directors")
    private String directors;
    @SerializedName("writers")
    private String writers;
    @SerializedName("actorList")
    private List<Actor> actors;
    @SerializedName("genres")
    private String genres;
    @SerializedName("images")
    private ItemsList<Image> images;
    @SerializedName("similars")
    private List<Movie> similarMovies;
    @SerializedName("contentRating")
    private String contentRating;
    @SerializedName("runtimeStr")
    private String runtime;
    @SerializedName("trailer")
    private Trailer trailer;
    @SerializedName("wikipedia")
    private Wikipedia wikipedia;

    public Wikipedia getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(Wikipedia wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public ItemsList<Image> getImages() {
        return images;
    }

    public void setImages(ItemsList<Image> images) {
        this.images = images;
    }

    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(List<Movie> similarMovies) {
        this.similarMovies = similarMovies;
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

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
