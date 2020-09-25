package com.example.imdbapplication.network;

import com.example.imdbapplication.utils.IMDBUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IMDbService {
    private static IMDbService instance;
    private Retrofit retrofit;

    private IMDbService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(IMDBUtil.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
    public static IMDbService getInstance() {
        if (instance == null) {
            instance = new IMDbService();
        }
        return instance;
    }

    public IMDbApi getApi() {
        return retrofit.create(IMDbApi.class);
    }
}
