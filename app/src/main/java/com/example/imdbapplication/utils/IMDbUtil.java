package com.example.imdbapplication.utils;

public interface IMDbUtil {
    // Api info
    String API_LANG = "en";
    String API_URL = "https://imdb-api.com/"+ API_LANG +"/API/";
    String IMDb_URL = "https://imdb.com/";

    // Queries api
    String QUERY_SEARCH_TITLE = "SearchTitle";
    String QUERY_TOP250MOVIES = "Top250Movies";
    String QUERY_MOST_POPULAR_MOVIES = "MostPopularMovies";
    String QUERY_IN_THEATERS = "InTheaters";
    String QUERY_BOX_OFFICE = "BoxOffice";
    String QUERY_BOX_OFFICE_ALL_TIME = "BoxOfficeAllTime";
    String QUERY_COMING_SOON = "ComingSoon";
    String QUERY_TITLE = "Title";
    String QUERY_FULL_CAST = "FullCast";
    String QUERY_NAME = "Name";
}
