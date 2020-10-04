package com.example.imdbapplication.ui.movie_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.FragmentRecycleCardsContainerBinding;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.ui.adapter.MoviesRecycleViewAdapter;
import com.example.imdbapplication.ui.movie_page.viewmodel.FullMovieViewModel;

import javax.inject.Inject;

public class SimilarMoviesFragment extends Fragment {
    public static final String TAG = "SimilarMoviesFragment";

    private TextView titleView;
    private RecyclerView recyclerView;
    private MoviesRecycleViewAdapter adapter;

    private FragmentRecycleCardsContainerBinding binding;

    @Inject
    public FullMovieViewModel viewModel;

    public SimilarMoviesFragment() {
        // Required empty public constructor
    }

    public static SimilarMoviesFragment newInstance() {
        SimilarMoviesFragment fragment = new SimilarMoviesFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((MoviePageActivity) requireActivity()).moviePageSubComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycle_cards_container, container, false);
        View view = binding.getRoot();
        initViews();

        Intent intent = getActivity().getIntent();
        String currentIdMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);
        setData(currentIdMovie);

        adapter = new MoviesRecycleViewAdapter(getActivity());
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initViews() {
        recyclerView = binding.recycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        titleView = binding.title;
    }

    private void setData(String id) {
        viewModel.getFullMovie(id).observe(getActivity(), new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                if (fullMovie != null) {
                    adapter.setMovieList(fullMovie.getSimilarMovies());
                }
            }
        });
        titleView.setText(R.string.title_similar_movies);
    }
}