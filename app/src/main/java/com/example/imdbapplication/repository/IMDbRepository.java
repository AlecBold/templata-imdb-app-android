package com.example.imdbapplication.repository;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.imdbapplication.data.FullMoviesCache;
import com.example.imdbapplication.network.IMDbApi;
import com.example.imdbapplication.network.IMDbService;
import com.example.imdbapplication.pojo.casts.ListActorCast;
import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.pojo.movie.ListSimilarMovie;
import com.example.imdbapplication.pojo.movie.TopMovie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IMDbRepository {
    public static final String TAG = "IMDbRepository";
    private static IMDbRepository instance;

    public static IMDbRepository getInstance() {
        if (instance == null) {
            instance = new IMDbRepository();
        }
        return instance;
    }

    private IMDbApi imDbApi;

    private IMDbRepository() {
        imDbApi = IMDbService.getInstance().getApi();
    }

    public MutableLiveData<ItemsList<TopMovie>> getTop250Movies() {
        MutableLiveData<ItemsList<TopMovie>> mutableLiveData = new MutableLiveData<>();
        imDbApi.getTop250Movies().enqueue(new Callback<ItemsList<TopMovie>>() {
            @Override
            public void onResponse(Call<ItemsList<TopMovie>> call, Response<ItemsList<TopMovie>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemsList<TopMovie>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<ComingMovie>> getComingSoon() {
        MutableLiveData<ItemsList<ComingMovie>> mutableLiveData =  new MutableLiveData<>();
        imDbApi.getComingSoon().enqueue(new Callback<ItemsList<ComingMovie>>() {
            @Override
            public void onResponse(Call<ItemsList<ComingMovie>> call, Response<ItemsList<ComingMovie>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemsList<ComingMovie>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<FullMovie> getFullMovie(String id) {

        MutableLiveData<FullMovie> mutableLiveData = new MutableLiveData<>();

        imDbApi.getFullMovie(id).enqueue(new Callback<FullMovie>() {
            @Override
            public void onResponse(Call<FullMovie> call, Response<FullMovie> response) {
                Log.d(TAG, "onResponse: ");
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FullMovie> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ListActorCast> getActorsCast(String id) {
        MutableLiveData<ListActorCast> mutableLiveData = new MutableLiveData<>();

        imDbApi.getActors(id).enqueue(new Callback<ListActorCast>() {
            @Override
            public void onResponse(Call<ListActorCast> call, Response<ListActorCast> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ListActorCast> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ListSimilarMovie> getSimilarMovies(String id) {
        MutableLiveData<ListSimilarMovie> mutableLiveData = new MutableLiveData<>();

        imDbApi.getSimilarMovies(id).enqueue(new Callback<ListSimilarMovie>() {
            @Override
            public void onResponse(Call<ListSimilarMovie> call, Response<ListSimilarMovie> response) {
                if (response.isSuccessful()) {
                    if (response.isSuccessful()) {
                        mutableLiveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ListSimilarMovie> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
