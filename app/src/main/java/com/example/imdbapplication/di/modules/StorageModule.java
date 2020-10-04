package com.example.imdbapplication.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.imdbapplication.data.DataStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @Singleton
    @Provides
    public DataStorage provideDataStorage(Context context) {
        return new DataStorage(context);
    }
}
