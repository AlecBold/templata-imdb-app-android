package com.example.imdbapplication.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.listeners.CardClickListener;
import com.example.imdbapplication.databinding.MovieItemCardBinding;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.ui.movie_page.MoviePageActivity;

import java.util.List;

public class MoviesRecycleViewAdapter extends RecyclerView.Adapter<MoviesRecycleViewAdapter.MovieHolder> implements CardClickListener {

    private List<Movie> movieList;
    private Context context;

    public MoviesRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_item_card, parent, false);
        MovieHolder holder = new MovieHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.binding.setMovie(movieList.get(position));
        holder.binding.setCardClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public void cardClicked(String id) {
        Intent intent = new Intent(context, MoviePageActivity.class);
        intent.putExtra(MoviePageActivity.KEY_ID_MOVIE, id);
        context.startActivity(intent);
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private MovieItemCardBinding binding;

        public MovieHolder(@NonNull MovieItemCardBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
