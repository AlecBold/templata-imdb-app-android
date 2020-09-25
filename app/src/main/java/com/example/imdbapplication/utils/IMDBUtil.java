package com.example.imdbapplication.utils;

public interface IMDBUtil {
    // Api info
    String API_LANG = "en";
    String API_KEY = "k_qL3zn7VQ";
    String API_URL = "https://imdb-api.com/"+ API_LANG +"/API/";

    // Queries
    String QUERY_SEARCH_ALL = "SearchAll";
    String QUERY_TOP250MOVIES = "Top250Movies";
    String QUERY_COMING_SOON = "ComingSoon";
    String QUERY_TITLE = "Title";
    String QUERY_FULL_CAST = "FullCast";
}
