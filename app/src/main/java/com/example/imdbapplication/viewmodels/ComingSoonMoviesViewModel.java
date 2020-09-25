package com.example.imdbapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.repository.IMDbRepository;

public class ComingSoonMoviesViewModel extends ViewModel {
    public static final String TAG = "ComingSoonViewModel";

    private MutableLiveData<ItemsList<ComingMovie>> mutableLiveData;
    private IMDbRepository repository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        repository = IMDbRepository.getInstance();
        mutableLiveData = repository.getComingSoon();
    }

    public LiveData<ItemsList<ComingMovie>> getAll() {
        return mutableLiveData;
    }

}
