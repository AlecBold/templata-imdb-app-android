package com.example.imdbapplication.network;

import com.example.imdbapplication.pojo.casts.Actor;
import com.example.imdbapplication.pojo.casts.FullActor;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.pojo.movie.SearchedMovie;
import com.example.imdbapplication.utils.IMDbUtil;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMDbApi {

    @GET(IMDbUtil.QUERY_SEARCH_TITLE + "/{api_key}/{expression}")
    Call<ResultList<SearchedMovie>> searchTitle(@Path("api_key") String api, @Path("expression") String expression);

    @GET(IMDbUtil.QUERY_TOP250MOVIES + "/{api_key}")
    Call<ItemsList<Movie>> getTop250Movies(@Path("api_key") String api);

    @GET(IMDbUtil.QUERY_COMING_SOON + "/{api_key}")
    Call<ItemsList<Movie>> getComingSoon(@Path("api_key") String api);

    @GET(IMDbUtil.QUERY_TITLE + "/{api_key}/{id}/Images,Trailer,Wikipedia")
    Call<FullMovie> getFullMovie(@Path("api_key") String api, @Path("id") String id);

    @GET(IMDbUtil.QUERY_FULL_CAST + "/{api_key}/{id}")
    Call<Actor> getActors(@Path("api_key") String api, @Path("id") String id);

    @GET(IMDbUtil.QUERY_TITLE + "/{api_key}/{id}")
    Call<Movie> getSimilarMovies(@Path("api_key") String api, @Path("id") String id);

    @GET(IMDbUtil.QUERY_NAME + "/{api_key}/{id}")
    Call<FullActor> getFullActor(@Path("api_key") String api, @Path("id") String id);

    @GET(IMDbUtil.QUERY_MOST_POPULAR_MOVIES + "/{api_key}")
    Call<ItemsList<Movie>> getMostPopularMovies(@Path("api_key") String api);

    @GET(IMDbUtil.QUERY_IN_THEATERS + "/{api_key}")
    Call<ItemsList<Movie>> getInTheaters(@Path("api_key") String api);

    @GET(IMDbUtil.QUERY_BOX_OFFICE + "/{api_key}")
    Call<ItemsList<Movie>> getBoxOffice(@Path("api_key") String api);

    @GET(IMDbUtil.QUERY_BOX_OFFICE_ALL_TIME + "/{api_key}")
    Call<ItemsList<Movie>> getBoxOfficeAllTime(@Path("api_key") String api);
}
