package com.example.imdbapplication.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.SearchListRecycleViewAdapter;
import com.example.imdbapplication.databinding.ActivitySeachBinding;
import com.example.imdbapplication.network.IMDbService;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.pojo.movie.SearchedMovie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    public static final String TAG = "SearchActivity";

    private SearchView searchView;
    private ImageView clearButton;


    private ProgressBar progressBar;

    private RecyclerView recyclerView;
    private SearchListRecycleViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        ActivitySeachBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_seach);
        setContentView(R.layout.activity_seach);
        initViews();
        setSupportActionBar();

        adapter = new SearchListRecycleViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.top_search_menu, menu);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu");
        searchView = (SearchView) menu.findItem(R.id.topSearchMenu_search).getActionView();
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        clearButton = searchView.findViewById(R.id.search_close_btn);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onClose() {
        finish();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.clearSearchedResultList();
        progressBar.setVisibility(View.VISIBLE);
        IMDbService.getInstance().getApi().searchAll(query).enqueue(new Callback<ResultList<SearchedMovie>>() {
            @Override
            public void onResponse(Call<ResultList<SearchedMovie>> call, Response<ResultList<SearchedMovie>> response) {
                Toast.makeText(SearchActivity.this, "on response", Toast.LENGTH_SHORT);
                adapter.setSearchedResultList(response.body().getResults());
                onBoth();
            }

            @Override
            public void onFailure(Call<ResultList<SearchedMovie>> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "on failure", Toast.LENGTH_SHORT);
                onBoth();
            }

            public void onBoth() {
                progressBar.setVisibility(View.GONE);
            }
        });
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.activitySearch_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.activitySearch_progressBar);
    }

    private void setSupportActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}