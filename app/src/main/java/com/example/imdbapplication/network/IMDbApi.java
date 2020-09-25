package com.example.imdbapplication.network;

import com.example.imdbapplication.pojo.casts.ListActorCast;
import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.pojo.movie.ListSimilarMovie;
import com.example.imdbapplication.pojo.movie.TopMovie;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.pojo.movie.SearchedMovie;
import com.example.imdbapplication.utils.IMDBUtil;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMDbApi {

    @GET(IMDBUtil.QUERY_SEARCH_ALL + "/" + IMDBUtil.API_KEY + "/{expression}")
    Call<ResultList<SearchedMovie>> searchAll(@Path("expression") String expression);

    @GET(IMDBUtil.QUERY_TOP250MOVIES + "/" + IMDBUtil.API_KEY)
    Call<ItemsList<TopMovie>> getTop250Movies();

    @GET(IMDBUtil.QUERY_COMING_SOON + "/" + IMDBUtil.API_KEY)
    Call<ItemsList<ComingMovie>> getComingSoon();

    @GET(IMDBUtil.QUERY_TITLE + "/" + IMDBUtil.API_KEY + "/{id}/Images,Trailer")
    Call<FullMovie> getFullMovie(@Path("id") String id);

    @GET(IMDBUtil.QUERY_FULL_CAST + "/" + IMDBUtil.API_KEY + "/{id}")
    Call<ListActorCast> getActors(@Path("id") String id);

    @GET(IMDBUtil.QUERY_TITLE + "/" + IMDBUtil.API_KEY + "/{id}")
    Call<ListSimilarMovie> getSimilarMovies(@Path("id") String id);
}
