package com.example.imdbapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.TopMovie;
import com.example.imdbapplication.repository.IMDbRepository;

public class Top250MoviesViewModel extends ViewModel {
    private MutableLiveData<ItemsList<TopMovie>> mutableLiveData;
    private IMDbRepository repository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        repository = IMDbRepository.getInstance();
        mutableLiveData = repository.getTop250Movies();
    }

    public LiveData<ItemsList<TopMovie>> getAll() {
        return mutableLiveData;
    }
}
