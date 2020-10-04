package com.example.imdbapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultList <T> {
    @SerializedName("results")
    private List<T> results;
    @SerializedName("errorMessage")
    private String errorMessage;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
