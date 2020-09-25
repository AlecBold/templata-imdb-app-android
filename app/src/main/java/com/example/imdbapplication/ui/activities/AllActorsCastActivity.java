package com.example.imdbapplication.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.ActorsListRecycleViewAdapter;
import com.example.imdbapplication.pojo.casts.ListActorCast;
import com.example.imdbapplication.viewmodels.ActorsViewModel;

public class AllActorsCastActivity extends AppCompatActivity {
    public static final String TAG = "AllActorsActivity";

    public static final String KEY_TITLE = "key_title";

    private TextView titleView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_actors_cast);
        setupActionBar();
        initViews();

        Intent intent = getIntent();
        String idMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);
        String title = intent.getStringExtra(KEY_TITLE);

        ActorsListRecycleViewAdapter adapter = new ActorsListRecycleViewAdapter(this, R.layout.vertical_item_card);
        recyclerView.setAdapter(adapter);

        ActorsViewModel viewModel = new ViewModelProvider(this).get(ActorsViewModel.class);
        viewModel.init(idMovie);

        viewModel.getActors().observe(this, new Observer<ListActorCast>() {
            @Override
            public void onChanged(ListActorCast listActorCast) {
                adapter.setActors(listActorCast.getActors());
            }
        });
        titleView.setText(title);
    }

    private void initViews() {
        titleView = findViewById(R.id.activityAllActors_title);
        recyclerView = findViewById(R.id.activityAllActors_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

}