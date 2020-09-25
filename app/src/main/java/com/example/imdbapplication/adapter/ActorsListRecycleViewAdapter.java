package com.example.imdbapplication.adapter;

import android.content.Context;

import com.example.imdbapplication.data_binding.CardClickListener;
import com.example.imdbapplication.data_binding.HorizontalCardController;
import com.example.imdbapplication.data_binding.VerticalCardController;
import com.example.imdbapplication.holders.HorizontalMovieHolder;
import com.example.imdbapplication.holders.VerticalMovieHolder;
import com.example.imdbapplication.pojo.casts.ActorCast;

import java.util.List;

public class ActorsListRecycleViewAdapter extends ListRecycleViewAdapter implements CardClickListener {

    private List<ActorCast> actors;

    public ActorsListRecycleViewAdapter(Context context, int resourceIdCard) {
        super(context, resourceIdCard);
    }

    public void setActors(List<ActorCast> actors) {
        this.actors = actors;
        notifyDataSetChanged();
    }

    @Override
    protected void bindHorizontalViewHolder(HorizontalMovieHolder holder, int position) {
        ActorCast actor = actors.get(position);
        HorizontalCardController cardController =
                new HorizontalCardController(actor.getId(), actor.getName(), actor.getUrlImage(), actor.getCharacter());
        holder.getHorizontalItemCardBinding().setCardClickListener(this);
        holder.getHorizontalItemCardBinding().setCard(cardController);
    }

    @Override
    protected void bindVerticalViewHolder(VerticalMovieHolder holder, int position) {
        ActorCast actor = actors.get(position);
        VerticalCardController cardController = new VerticalCardController();
        cardController.setId(actor.getId());
        cardController.setTitle(actor.getName());
        cardController.setImgUrl(actor.getUrlImage());
        cardController.setMidTxt1(actor.getCharacter());

        holder.getVerticalItemCardBinder().setCardClickListener(this);
        holder.getVerticalItemCardBinder().setCard(cardController);
    }

    @Override
    public int getItemCount() {
        if (actors != null) {
            return actors.size();
        }
        return 0;
    }

    @Override
    public void cardClicked(String id) {
        //TODO: implement actor activity
    }
}
