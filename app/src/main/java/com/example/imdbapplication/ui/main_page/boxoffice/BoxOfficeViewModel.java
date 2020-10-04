package com.example.imdbapplication.ui.main_page.boxoffice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class BoxOfficeViewModel extends ViewModel {

    private IMDbRepository repository;
    private MutableLiveData<ItemsList<Movie>> mutableLiveData;

    @Inject
    public BoxOfficeViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ItemsList<Movie>> getBoxOffice() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getBoxOffice();
        }
        return mutableLiveData;
    }
}
