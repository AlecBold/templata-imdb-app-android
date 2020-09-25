package com.example.imdbapplication.ui.fragments;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.Top250ListRecycleViewAdapter;
import com.example.imdbapplication.databinding.FragmentSimilarMoviesBinding;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.ui.activities.AllMoviesActivity;
import com.example.imdbapplication.ui.activities.MoviePageActivity;
import com.example.imdbapplication.viewmodels.FullMovieViewModel;
import com.example.imdbapplication.viewmodels.Top250MoviesViewModel;

public class SimilarMoviesFragment extends Fragment {
    public static final String TAG = "SimilarMoviesFragment";

    private RecyclerView recyclerView;
    private Top250ListRecycleViewAdapter adapter;

    private Button btnAll;
    private TextView title;

    private FragmentSimilarMoviesBinding binding;

    private FullMovieViewModel viewModel;

    private String currentIdMovie;

    public SimilarMoviesFragment() {
        // Required empty public constructor
    }
    public static SimilarMoviesFragment newInstance() {
        SimilarMoviesFragment fragment = new SimilarMoviesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_similar_movies, container, false);
        View view = binding.getRoot();
        initViews();

        Intent intent = getActivity().getIntent();
        currentIdMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);

        adapter = new Top250ListRecycleViewAdapter(getActivity(), R.layout.horizontal_item_card);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(getActivity()).get(FullMovieViewModel.class);
        viewModel.init(currentIdMovie);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AllMoviesActivity.class);
                intent.putExtra(MoviePageActivity.KEY_ID_MOVIE, currentIdMovie);
                intent.putExtra(AllMoviesActivity.KEY_TAG_FRAGMENT, TAG);
                intent.putExtra(AllMoviesActivity.KEY_TITLE, title.getText());
                startActivity(intent);
            }
        });

        setData();

        return view;
    }

    private void initViews() {
        recyclerView = binding.recycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        btnAll = binding.btnAll.btnAll;
        title = binding.title;
    }

    private void setData() {
        viewModel.getAll().observe(getActivity(), new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                adapter.setMovieCardList(fullMovie.getSimilarMovies());
            }
        });
    }
}