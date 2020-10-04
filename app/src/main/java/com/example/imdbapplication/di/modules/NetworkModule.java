package com.example.imdbapplication.di.modules;

import com.example.imdbapplication.network.IMDbApi;
import com.example.imdbapplication.utils.IMDbUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  
    @Singleton
    @Provides
    public Retrofit provideIMDbService() {
        return new Retrofit.Builder()
          .baseUrl(IMDbUtil.API_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

}
