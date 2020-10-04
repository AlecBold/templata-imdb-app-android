package com.example.imdbapplication.di.modules;

import android.content.Context;
import android.provider.ContactsContract;

import com.example.imdbapplication.data.DataStorage;
import com.example.imdbapplication.repository.IMDbRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public IMDbRepository provideRepository(DataStorage dataStorage, Retrofit retrofit) {
        return new IMDbRepository(dataStorage, retrofit);
    }
}
