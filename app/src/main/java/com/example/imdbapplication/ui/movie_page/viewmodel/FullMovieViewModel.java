package com.example.imdbapplication.ui.movie_page.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class FullMovieViewModel extends ViewModel {
    public static final String TAG = "FullMovieVM";

    private MutableLiveData<FullMovie> mutableLiveData;
    private IMDbRepository repository;

    @Inject
    public FullMovieViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public LiveData<FullMovie> getFullMovie(String id) {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getFullMovie(id);
        }
        return mutableLiveData;
    }

}
