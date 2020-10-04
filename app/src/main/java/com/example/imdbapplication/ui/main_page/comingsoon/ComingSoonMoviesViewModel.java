package com.example.imdbapplication.ui.main_page.comingsoon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class ComingSoonMoviesViewModel extends ViewModel {
    public static final String TAG = "ComingSoonViewModel";

    private MutableLiveData<ItemsList<Movie>> mutableLiveData;
    private IMDbRepository repository;

    @Inject
    public ComingSoonMoviesViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public LiveData<ItemsList<Movie>> getComingSoon() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getComingSoon();
        }
        return mutableLiveData;
    }

}
