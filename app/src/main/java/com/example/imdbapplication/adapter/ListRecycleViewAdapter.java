package com.example.imdbapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.HorizontalItemCardBinding;
import com.example.imdbapplication.databinding.VerticalItemCardBinding;
import com.example.imdbapplication.holders.HorizontalMovieHolder;
import com.example.imdbapplication.holders.VerticalMovieHolder;

public abstract class ListRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "MoviesRecyclerAdapter";

    protected Context context;
    protected int resourceIdCard;


    public ListRecycleViewAdapter(Context context, int resourceIdCard) {
        this.context = context;
        this.resourceIdCard = resourceIdCard;
        Log.d(TAG, "MoviesRecycleViewAdapter: ");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;

        switch (resourceIdCard) {
            case R.layout.horizontal_item_card:
                HorizontalItemCardBinding hBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(context), resourceIdCard, parent, false);
                holder = new HorizontalMovieHolder(hBinding);
                break;
            case R.layout.vertical_item_card:
                VerticalItemCardBinding vBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(context), resourceIdCard, parent, false);
                holder = new VerticalMovieHolder(vBinding);
                break;
            default:
                return null;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (resourceIdCard) {
            case R.layout.horizontal_item_card:
                HorizontalMovieHolder hrzHolder = (HorizontalMovieHolder) holder;
                bindHorizontalViewHolder(hrzHolder, position);
                break;
            case R.layout.vertical_item_card:
                VerticalMovieHolder vrtHolder = (VerticalMovieHolder) holder;
                bindVerticalViewHolder(vrtHolder, position);
                break;
        }
    }


    abstract protected void bindHorizontalViewHolder(HorizontalMovieHolder holder, int position);

    abstract protected void bindVerticalViewHolder(VerticalMovieHolder holder, int position);
}
