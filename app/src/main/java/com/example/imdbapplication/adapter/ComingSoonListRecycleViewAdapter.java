package com.example.imdbapplication.adapter;

import android.content.Context;
import android.content.Intent;

import com.example.imdbapplication.data_binding.CardClickListener;
import com.example.imdbapplication.data_binding.HorizontalCardController;
import com.example.imdbapplication.data_binding.VerticalCardController;
import com.example.imdbapplication.holders.HorizontalMovieHolder;
import com.example.imdbapplication.holders.VerticalMovieHolder;
import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.ui.activities.MoviePageActivity;

import java.util.List;

public class ComingSoonListRecycleViewAdapter extends ListRecycleViewAdapter implements CardClickListener {

    private List<ComingMovie> comingSoonMovieList;

    public ComingSoonListRecycleViewAdapter(Context context, int resourceId) {
        super(context, resourceId);
    }

    @Override
    public int getItemCount() {
        if (comingSoonMovieList != null) {
            return comingSoonMovieList.size();
        }
        return 0;
    }

    public void setComingSoonMovieList(List<ComingMovie> list) {
        comingSoonMovieList = list;
        notifyDataSetChanged();
    }

    @Override
    protected void bindHorizontalViewHolder(HorizontalMovieHolder holder, int position) {
        ComingMovie movie = comingSoonMovieList.get(position);
        HorizontalCardController cardController =
                new HorizontalCardController(movie.getId(), movie.getTitle(), movie.getImgUrl(), movie.getRelease());
        holder.getHorizontalItemCardBinding().setCardClickListener(this);
        holder.getHorizontalItemCardBinding().setCard(cardController);

    }

    @Override
    protected void bindVerticalViewHolder(VerticalMovieHolder holder, int position) {
        ComingMovie movie = comingSoonMovieList.get(position);
        VerticalCardController cardController = new VerticalCardController();
        cardController.setId(movie.getId());
        cardController.setTitle(movie.getTitle());
        cardController.setImgUrl(movie.getImgUrl());
        cardController.setMidTxt1(movie.getRelease());
        cardController.setMidTxt2(movie.getYear());
        cardController.setMidTxt3(movie.getRuntime());
        cardController.setMidTxt4(movie.getContentRating());
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
