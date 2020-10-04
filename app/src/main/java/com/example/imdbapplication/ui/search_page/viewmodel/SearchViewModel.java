package com.example.imdbapplication.ui.search_page.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.pojo.movie.SearchedMovie;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

@ActivityScope
public class SearchViewModel extends ViewModel {
    private static final String TAG = "SearchViewModel";
    private IMDbRepository repository;

    @Inject
    public SearchViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    public LiveData<ResultList<SearchedMovie>> searchTitle(String query) {
        Log.d(TAG, "searchAll: " + query);
        return repository.searchTitle(query);
    }
}
