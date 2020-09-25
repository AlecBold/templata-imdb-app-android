package com.example.imdbapplication.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.Top250ListRecycleViewAdapter;
import com.example.imdbapplication.databinding.FragmentTop250MoviesBinding;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.TopMovie;
import com.example.imdbapplication.ui.activities.AllMoviesActivity;
import com.example.imdbapplication.viewmodels.Top250MoviesViewModel;

public class Top250MoviesFragment extends Fragment {
    public static final String TAG = "Top250MoviesFragment";

    private Top250ListRecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    private Top250MoviesViewModel viewModel;

    private Button btnAll;
    private TextView title;

    private FragmentTop250MoviesBinding binding;

    public Top250MoviesFragment() {
        // Required empty public constructor
    }

    public static Top250MoviesFragment newInstance() {
        Top250MoviesFragment fragment = new Top250MoviesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top250_movies, container, false);
        View view = binding.getRoot();
        initViews();

        adapter = new Top250ListRecycleViewAdapter(getActivity(), R.layout.horizontal_item_card);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(getActivity()).get(Top250MoviesViewModel.class);
        viewModel.init();

        setData();

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AllMoviesActivity.class);
                intent.putExtra(AllMoviesActivity.KEY_TAG_FRAGMENT, TAG);
                intent.putExtra(AllMoviesActivity.KEY_TITLE, title.getText());
                startActivity(intent);
            }
        });

        return view;
    }
    
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    private void initViews() {
        recyclerView = binding.top250moviesRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        btnAll = binding.top250moviesBtnSeeAll.btnAll;
        title = binding.top250moviesTitle;
    }

    private void setData() {
        viewModel.getAll().observe(getActivity(), new Observer<ItemsList<TopMovie>>() {
            @Override
            public void onChanged(ItemsList<TopMovie> movieCardItemsList) {
                adapter.setMovieCardList(movieCardItemsList.getItems());
            }
        });
    }
}