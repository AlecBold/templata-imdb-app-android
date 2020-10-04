package com.example.imdbapplication.preference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.example.imdbapplication.R;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiKeyValidator {
    public IMDbRepository repository;

    @Inject
    public ApiKeyValidator(IMDbRepository repository) {
        this.repository = repository;
    }

    public String getApiKey() {
        return repository.getApiKey();
    }

    public boolean isApiKeySet() {
        return !repository.getApiKey().equals("");
    }
}
