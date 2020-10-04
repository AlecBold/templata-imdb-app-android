package com.example.imdbapplication.ui.main_page.mostpopularmovies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class MostPopularsMovieViewModel extends ViewModel {
    private IMDbRepository repository;
    private MutableLiveData<ItemsList<Movie>> mutableLiveData;

    @Inject
    public MostPopularsMovieViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public LiveData<ItemsList<Movie>> getMostPopularMovies() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getMostPopularMovies();
        }
        return mutableLiveData;
    }
}
