package com.example.imdbapplication.ui.search_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.imdbapplication.IMDBApplication;
import com.example.imdbapplication.R;
import com.example.imdbapplication.pojo.movie.SearchedMovie;
import com.example.imdbapplication.ui.adapter.SearchListRecycleViewAdapter;
import com.example.imdbapplication.databinding.ActivitySeachBinding;
import com.example.imdbapplication.pojo.ResultList;
import com.example.imdbapplication.popup.PopUpErrorHelper;
import com.example.imdbapplication.ui.search_page.viewmodel.SearchViewModel;

import javax.inject.Inject;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    public static final String TAG = "SearchActivity";

    @Inject
    public SearchViewModel viewModel;

    private RecyclerView recyclerView;
    private SearchListRecycleViewAdapter adapter;

    private ActivitySeachBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((IMDBApplication) getApplication()).getAppComponent().searchComponent().create().inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_seach);
        initViews();
        setupActionBar();

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
        SearchView searchView = (SearchView) menu.findItem(R.id.topSearchMenu_search).getActionView();
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

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
        binding.setIsSearching(true);
        viewModel.searchTitle(query).observe(this, new Observer<ResultList<SearchedMovie>>() {
            @Override
            public void onChanged(ResultList<SearchedMovie> searchedMovieResultList) {
                if (searchedMovieResultList != null &&
                        !PopUpErrorHelper.showToastIfErrorMessage(SearchActivity.this, searchedMovieResultList.getErrorMessage())) {
                    adapter.setSearchedResultList(searchedMovieResultList.getResults());
                    binding.setIsSearching(false);
                } else {
                    Toast.makeText(SearchActivity.this, R.string.error_connection_problem, Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
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
        recyclerView = binding.activitySearchRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}