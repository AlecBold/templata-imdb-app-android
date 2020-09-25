package com.example.imdbapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.pojo.casts.ListActorCast;
import com.example.imdbapplication.repository.IMDbRepository;

public class ActorsViewModel extends ViewModel {
    private MutableLiveData<ListActorCast> mutableLiveData;
    private IMDbRepository repository;

    public void init(String id) {
        if (mutableLiveData != null) {
            return;
        }
        repository = IMDbRepository.getInstance();
        mutableLiveData = repository.getActorsCast(id);
    }

    public LiveData<ListActorCast> getActors() {
        return mutableLiveData;
    }
}
