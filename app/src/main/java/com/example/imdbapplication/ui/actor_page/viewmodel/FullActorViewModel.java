package com.example.imdbapplication.ui.actor_page.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imdbapplication.pojo.casts.FullActor;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;

public class FullActorViewModel extends ViewModel {
    private IMDbRepository repository;

    @Inject
    public FullActorViewModel(IMDbRepository repository) {
        this.repository = repository;
    }

    private MutableLiveData<FullActor> mutableLiveData;

    public LiveData<FullActor> getFullActor(String id) {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getFullActor(id);
        }
        return mutableLiveData;
    }
}
