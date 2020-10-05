package com.example.imdbapplication.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.utils.listeners.CardClickListener;
import com.example.imdbapplication.databinding.ActorItemCardBinding;
import com.example.imdbapplication.pojo.casts.Actor;
import com.example.imdbapplication.ui.actor_page.ActorPageActivity;

import java.util.List;

public class ActorsRecycleViewAdapter extends RecyclerView.Adapter<ActorsRecycleViewAdapter.ActorHolder> implements CardClickListener {

    private Context context;
    private List<Actor> actorList;

    public ActorsRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ActorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActorItemCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.actor_item_card, parent, false);
        ActorHolder holder = new ActorHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorHolder holder, int position) {
        holder.binding.setActor(actorList.get(position));
        holder.binding.setCardClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (actorList != null) {
            return actorList.size();
        }
        return 0;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
        notifyDataSetChanged();
    }

    @Override
    public void cardClicked(String id) {
        Intent intent = new Intent(context, ActorPageActivity.class);
        intent.putExtra(ActorPageActivity.KEY_ID_ACTOR, id);
        context.startActivity(intent);
    }

    public class ActorHolder extends RecyclerView.ViewHolder {

        private ActorItemCardBinding binding;

        public ActorHolder(@NonNull ActorItemCardBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
