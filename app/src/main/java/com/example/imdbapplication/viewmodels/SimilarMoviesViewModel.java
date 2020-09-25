package com.example.imdbapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.pojo.movie.ListSimilarMovie;
import com.example.imdbapplication.repository.IMDbRepository;

public class SimilarMoviesViewModel extends ViewModel {
    private MutableLiveData<ListSimilarMovie> mutableLiveData;
    private IMDbRepository repository;

    public void init(String id) {
        if (mutableLiveData != null) {
            return;
        }
        repository = IMDbRepository.getInstance();
        mutableLiveData = repository.getSimilarMovies(id);
    }

    public LiveData<ListSimilarMovie> getSimilarMovies() {
        return mutableLiveData;
    }
}
