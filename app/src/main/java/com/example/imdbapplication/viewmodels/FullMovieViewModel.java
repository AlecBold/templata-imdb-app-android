package com.example.imdbapplication.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.imdbapplication.network.IMDbService;
import com.example.imdbapplication.pojo.casts.ActorCast;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.repository.IMDbRepository;

import java.util.List;

public class FullMovieViewModel extends ViewModel {
    public static final String TAG = "FullMovieVM";

    private MutableLiveData<FullMovie> mutableLiveData;
    private IMDbRepository repository;

    public void init(String id) {
        if (mutableLiveData != null) {
            return;
        }
        repository = IMDbRepository.getInstance();
        mutableLiveData = repository.getFullMovie(id);
    }


    public LiveData<FullMovie> getAll() {
        return mutableLiveData;
    }

}
