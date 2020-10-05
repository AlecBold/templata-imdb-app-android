package com.example.imdbapplication.repository;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.imdbapplication.data.DataStorage;
import com.example.imdbapplication.network.IMDbApi;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.pojo.casts.Actor;
import com.example.imdbapplication.pojo.casts.FullActor;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.pojo.movie.SearchedMovie;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Singleton
public class IMDbRepository {
    public static final String TAG = "IMDbRepository";

    private Retrofit retrofit;
    private DataStorage dataStorage;

    @Inject
    public IMDbRepository(DataStorage dataStorage, Retrofit retrofit) {
        this.retrofit = retrofit;
        this.dataStorage = dataStorage;
    }

    public MutableLiveData<ResultList<SearchedMovie>> searchTitle(String query) {
        MutableLiveData<ResultList<SearchedMovie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).searchTitle(dataStorage.getApiKey(), query)
                .enqueue(new Callback<ResultList<SearchedMovie>>() {
            @Override
            public void onResponse(Call<ResultList<SearchedMovie>> call, Response<ResultList<SearchedMovie>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResultList<SearchedMovie>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getTop250Movies() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getTop250Movies(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
            @Override
            public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getComingSoon() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData =  new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getComingSoon(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
            @Override
            public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getMostPopularMovies() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getMostPopularMovies(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
                    @Override
                    public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                        if (response.isSuccessful()) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        mutableLiveData.setValue(null);
                    }
                });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getInTheaters() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getInTheaters(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
                    @Override
                    public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                        if (response.isSuccessful()) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        mutableLiveData.setValue(null);
                    }
                });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getBoxOffice() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getBoxOffice(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
                    @Override
                    public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                        if (response.isSuccessful()) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        mutableLiveData.setValue(null);
                    }
                });
        return mutableLiveData;
    }

    public MutableLiveData<ItemsList<Movie>> getBoxOfficeAllTime() {
        MutableLiveData<ItemsList<Movie>> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getBoxOfficeAllTime(dataStorage.getApiKey())
                .enqueue(new Callback<ItemsList<Movie>>() {
                    @Override
                    public void onResponse(Call<ItemsList<Movie>> call, Response<ItemsList<Movie>> response) {
                        if (response.isSuccessful()) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemsList<Movie>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        mutableLiveData.setValue(null);
                    }
                });
        return mutableLiveData;
    }

    public MutableLiveData<FullMovie> getFullMovie(String id) {
        MutableLiveData<FullMovie> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getFullMovie(dataStorage.getApiKey(), id)
                .enqueue(new Callback<FullMovie>() {
            @Override
            public void onResponse(Call<FullMovie> call, Response<FullMovie> response) {
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

    public MutableLiveData<Actor> getActorsCast(String id) {
        MutableLiveData<Actor> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getActors(dataStorage.getApiKey(), id).enqueue(new Callback<Actor>() {
            @Override
            public void onResponse(Call<Actor> call, Response<Actor> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Actor> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<Movie> getSimilarMovies(String id) {
        MutableLiveData<Movie> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getSimilarMovies(dataStorage.getApiKey(), id).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    if (response.isSuccessful()) {
                        mutableLiveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<FullActor> getFullActor(String id) {
        MutableLiveData<FullActor> mutableLiveData = new MutableLiveData<>();
        retrofit.create(IMDbApi.class).getFullActor(dataStorage.getApiKey(), id).enqueue(new Callback<FullActor>() {
            @Override
            public void onResponse(Call<FullActor> call, Response<FullActor> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FullActor> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    public String getApiKey() {
        return dataStorage.getApiKey();
    }
}
