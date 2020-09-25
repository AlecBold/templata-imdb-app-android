package com.example.imdbapplication.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.ActorsListRecycleViewAdapter;
import com.example.imdbapplication.adapter.ComingSoonListRecycleViewAdapter;
import com.example.imdbapplication.adapter.ListRecycleViewAdapter;
import com.example.imdbapplication.adapter.Top250ListRecycleViewAdapter;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.pojo.movie.ListSimilarMovie;
import com.example.imdbapplication.pojo.movie.TopMovie;
import com.example.imdbapplication.ui.fragments.CastFragment;
import com.example.imdbapplication.ui.fragments.ComingSoonFragment;
import com.example.imdbapplication.ui.fragments.SimilarMoviesFragment;
import com.example.imdbapplication.ui.fragments.Top250MoviesFragment;
import com.example.imdbapplication.viewmodels.ComingSoonMoviesViewModel;
import com.example.imdbapplication.viewmodels.FullMovieViewModel;
import com.example.imdbapplication.viewmodels.SimilarMoviesViewModel;
import com.example.imdbapplication.viewmodels.Top250MoviesViewModel;

public class AllMoviesActivity extends AppCompatActivity {
    public static final String TAG = "AllMoviesActivity";

    public static final String KEY_TAG_FRAGMENT = "key_tag";
    public static final String KEY_TITLE = "key_title";

    private TextView titleView;

    private RecyclerView recyclerView;
    private ListRecycleViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        setupActionBar();
        initViews();

        Intent intent = getIntent();
        String tag = intent.getExtras().getString(KEY_TAG_FRAGMENT);
        String title = intent.getExtras().getString(KEY_TITLE);

        switch (tag) {
            case ComingSoonFragment.TAG:
                ComingSoonListRecycleViewAdapter comingAdapter =
                        new ComingSoonListRecycleViewAdapter(this, R.layout.vertical_item_card);

                ComingSoonMoviesViewModel comingViewModel = new ViewModelProvider(this).get(ComingSoonMoviesViewModel.class);
                comingViewModel.init();

                comingViewModel.getAll().observe(this, new Observer<ItemsList<ComingMovie>>() {
                    @Override
                    public void onChanged(ItemsList<ComingMovie> comingSoonMovieItemsList) {
                        comingAdapter.setComingSoonMovieList(comingSoonMovieItemsList.getItems());
                    }
                });
                adapter = comingAdapter;
                break;

            case Top250MoviesFragment.TAG:
                Top250ListRecycleViewAdapter topAdapter =
                        new Top250ListRecycleViewAdapter(this, R.layout.vertical_item_card);

                Top250MoviesViewModel topViewModel  = new ViewModelProvider(this).get(Top250MoviesViewModel.class);
                topViewModel.init();

                topViewModel.getAll().observe(this, new Observer<ItemsList<TopMovie>>() {
                    @Override
                    public void onChanged(ItemsList<TopMovie> movieCardItemsList) {
                        topAdapter.setMovieCardList(movieCardItemsList.getItems());
                    }
                });
                adapter = topAdapter;
                break;

            case SimilarMoviesFragment.TAG:
                String idMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);

                Top250ListRecycleViewAdapter similarMoviesAdapter =
                        new Top250ListRecycleViewAdapter(this, R.layout.vertical_item_card);

                SimilarMoviesViewModel similarMoviesViewModel = new ViewModelProvider(this).get(SimilarMoviesViewModel.class);
                similarMoviesViewModel.init(idMovie);

                similarMoviesViewModel.getSimilarMovies().observe(this, new Observer<ListSimilarMovie>() {
                    @Override
                    public void onChanged(ListSimilarMovie listSimilarMovie) {
                        similarMoviesAdapter.setMovieCardList(listSimilarMovie.getSimilarMovies());
                    }
                });
                adapter = similarMoviesAdapter;
                break;

            default:
                return;
        }
        recyclerView.setAdapter(adapter);
        titleView.setText(title);
    }

    private void initViews() {
        titleView = findViewById(R.id.activityAllMovies_title);
        recyclerView = findViewById(R.id.activityAllMovies_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

}