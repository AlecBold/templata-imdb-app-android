package com.example.imdbapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imdbapplication.R;
import com.example.imdbapplication.data_binding.CardClickListener;
import com.example.imdbapplication.databinding.ListItemSearchBinding;
import com.example.imdbapplication.pojo.movie.SearchedMovie;
import com.example.imdbapplication.ui.activities.MoviePageActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchListRecycleViewAdapter extends RecyclerView.Adapter<SearchListRecycleViewAdapter.SearchHolder> implements CardClickListener {
    public static final String TAG = "SearchListRecycleViewAdapter";

    private List<SearchedMovie> searchedResultList;
    private Context context;

    public SearchListRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemSearchBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(context), R.layout.list_item_search, parent, false);
        SearchHolder holder = new SearchHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        SearchedMovie searched = searchedResultList.get(position);
        holder.binding.setMovie(searched);
        holder.binding.setOnCardClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (searchedResultList != null) {
            return searchedResultList.size();
        }
        return 0;
    }

    public void setSearchedResultList(List<SearchedMovie> searchedResultList) {
        this.searchedResultList = searchedResultList;
        notifyDataSetChanged();
    }

    public void clearSearchedResultList() {
        if (searchedResultList == null) {
            searchedResultList = new ArrayList<>();
        }
        searchedResultList.clear();
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        private ListItemSearchBinding binding;

        public SearchHolder(@NonNull ListItemSearchBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }

    @Override
    public void cardClicked(String id) {
        Intent intent = new Intent(context, MoviePageActivity.class);
        intent.putExtra(MoviePageActivity.KEY_ID_MOVIE, id);
        context.startActivity(intent);
    }
}
