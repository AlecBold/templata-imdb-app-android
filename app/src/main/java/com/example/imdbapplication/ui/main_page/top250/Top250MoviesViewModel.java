package com.example.imdbapplication.ui.main_page.top250;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class Top250MoviesViewModel extends ViewModel {
    public static final String TAG = "Top250VM";

    private MutableLiveData<ItemsList<Movie>> mutableLiveData;
    private IMDbRepository repository;

    @Inject
    public Top250MoviesViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public LiveData<ItemsList<Movie>> getTop250Movies() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getTop250Movies();
        }
        return mutableLiveData;
    }
}
