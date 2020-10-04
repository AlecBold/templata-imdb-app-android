package com.example.imdbapplication.ui.main_page.boxofficealltime;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class BoxOfficeAllTimeViewModel extends ViewModel {
    private IMDbRepository repository;
    private MutableLiveData<ItemsList<Movie>> mutableLiveData;

    @Inject
    public BoxOfficeAllTimeViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ItemsList<Movie>> getBoxOfficeAllTime() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getBoxOfficeAllTime();
        }
        return mutableLiveData;
    }
}
