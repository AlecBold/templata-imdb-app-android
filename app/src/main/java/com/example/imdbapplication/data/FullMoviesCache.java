package com.example.imdbapplication.data;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.imdbapplication.pojo.movie.FullMovie;

import java.util.LinkedHashMap;


public class FullMoviesCache {
    private static final int MAX_NUM_MOVIES = 10;

    private static FullMoviesCache instance;

    private LinkedHashMap<String, FullMovie> movies;

    private FullMoviesCache() {
        movies = new LinkedHashMap<String, FullMovie>() {
            @Override
            protected boolean removeEldestEntry(Entry eldest) {
                return size() > MAX_NUM_MOVIES;
            }
        };
    }

    public static FullMoviesCache getInstance() {
        if (instance == null) {
            instance = new FullMoviesCache();
        }
        return instance;
    }

    public MutableLiveData<FullMovie> getMovieById(String id) {
        MutableLiveData<FullMovie> fullMovieLiveData = new MutableLiveData<>();
        fullMovieLiveData.setValue(movies.get(id));
        return fullMovieLiveData;
    }

    public void putMovie(FullMovie fullMovie) {
        if (movies.containsKey(fullMovie.getId())) {
            return;
        }
        movies.put(fullMovie.getId(), fullMovie);
    }

}
