package com.example.imdbapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.imdbapplication.data_binding.CardClickListener;
import com.example.imdbapplication.data_binding.HorizontalCardController;
import com.example.imdbapplication.data_binding.VerticalCardController;
import com.example.imdbapplication.holders.HorizontalMovieHolder;
import com.example.imdbapplication.holders.VerticalMovieHolder;
import com.example.imdbapplication.pojo.movie.TopMovie;
import com.example.imdbapplication.ui.activities.MoviePageActivity;

import java.util.List;

public class Top250ListRecycleViewAdapter extends ListRecycleViewAdapter implements CardClickListener {
    public static final String TAG = "Top250MoviesAdapter";

    private List<TopMovie> movieCardList;

    public Top250ListRecycleViewAdapter(Context context, int resourceIdCard) {
        super(context, resourceIdCard);
    }

    @Override
    public int getItemCount() {
        if (movieCardList != null) {
            return movieCardList.size();
        }
        return 0;
    }

    public void setMovieCardList(List<TopMovie> list) {
        movieCardList = list;
        Log.d(TAG, "setMovieCardList: ");
        notifyDataSetChanged();
    }

    @Override
    protected void bindHorizontalViewHolder(HorizontalMovieHolder holder, int position) {
        TopMovie movie = movieCardList.get(position);
        HorizontalCardController cardController =
                new HorizontalCardController(movie.getId(), movie.getTitle(), movie.getImgUrl(), movie.getImDbRating());
        holder.getHorizontalItemCardBinding().setCardClickListener(this);
        holder.getHorizontalItemCardBinding().setCard(cardController);
    }

    @Override
    protected void bindVerticalViewHolder(VerticalMovieHolder holder, int position) {
        TopMovie movie = movieCardList.get(position);
        VerticalCardController cardController = new VerticalCardController();
        cardController.setId(movie.getId());
        cardController.setTitle(movie.getTitle());
        cardController.setImgUrl(movie.getImgUrl());
        cardController.setMidTxt1(movie.getYear());
        cardController.setBottomTxt(movie.getImDbRating());
        holder.getVerticalItemCardBinder().setCardClickListener(this);
        holder.getVerticalItemCardBinder().setCard(cardController);
    }

    @Override
    public void cardClicked(String id) {
        Intent intent = new Intent(context, MoviePageActivity.class);
        intent.putExtra(MoviePageActivity.KEY_ID_MOVIE, id);
        context.startActivity(intent);
    }
}
