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
import com.example.imdbapplication.databinding.FragmentCastBinding;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.ui.adapter.ActorsRecycleViewAdapter;
import com.example.imdbapplication.ui.movie_page.viewmodel.FullMovieViewModel;

import javax.inject.Inject;

public class CastFragment extends Fragment {
    public static final String TAG = "CastFragment";

    private RecyclerView recyclerView;
    private ActorsRecycleViewAdapter adapter;

    @Inject
    public FullMovieViewModel viewModel;

    private TextView titleView;

    private FragmentCastBinding binding;

    private String currentIdMovie;

    public CastFragment() {
        // Required empty public constructor
    }

    public static CastFragment newInstance() {
        CastFragment fragment = new CastFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cast, container, false);
        View view = binding.getRoot();
        initViews();

        Intent intent = getActivity().getIntent();
        currentIdMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);
        setData();

        adapter = new ActorsRecycleViewAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initViews() {
        recyclerView = binding.fragmentCastRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        titleView = binding.fragmentCastTitle;
    }

    private void setData() {
        viewModel.getFullMovie(currentIdMovie).observe(getActivity(), new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                if (fullMovie != null) {
                    adapter.setActorList(fullMovie.getActors());
                    binding.setWriters(fullMovie.getWriters());
                    binding.setDirectors(fullMovie.getDirectors());
                }
            }
        });
        titleView.setText(R.string.title_cast);
    }
}