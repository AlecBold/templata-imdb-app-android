package com.example.imdbapplication.ui.fragments;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.adapter.ActorsListRecycleViewAdapter;
import com.example.imdbapplication.databinding.FragmentCastBinding;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.ui.activities.AllActorsCastActivity;
import com.example.imdbapplication.ui.activities.MoviePageActivity;
import com.example.imdbapplication.viewmodels.FullMovieViewModel;

public class CastFragment extends Fragment implements View.OnClickListener{
    public static final String TAG = "CastFragment";

    private RecyclerView recyclerView;
    private ActorsListRecycleViewAdapter adapter;

    private FullMovieViewModel viewModel;

    private Button btnAllView;
    private TextView titleView;

    private LinearLayout directorsLayout;
    private LinearLayout writersLayout;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cast, container, false);
        View view = binding.getRoot();
        initViews();

        Intent intent = getActivity().getIntent();
        currentIdMovie = intent.getStringExtra(MoviePageActivity.KEY_ID_MOVIE);

        adapter = new ActorsListRecycleViewAdapter(getActivity(), R.layout.horizontal_item_card);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(getActivity()).get(FullMovieViewModel.class);
        viewModel.init(currentIdMovie);

        setData();

        directorsLayout.setOnClickListener(this);
        writersLayout.setOnClickListener(this);
        btnAllView.setOnClickListener(this);

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
        btnAllView = binding.fragmentCastBtnAll.btnAll;
        directorsLayout = binding.fragmentCastDirectorsLayout;
        writersLayout = binding.fragmentCastWritersLayout;
    }

    private void setData() {
        viewModel.getAll().observe(getActivity(), new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                adapter.setActors(fullMovie.getActors());
                binding.setWriters(fullMovie.getWriters());
                binding.setDirectors(fullMovie.getDirectors());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // Open actors list
            case R.id.fragmentCast_btnAll:
                Intent intent = new Intent(getContext(), AllActorsCastActivity.class);
                intent.putExtra(MoviePageActivity.KEY_ID_MOVIE, currentIdMovie);
                intent.putExtra(AllActorsCastActivity.KEY_TITLE, titleView.getText());
                startActivity(intent);
                return;
            // Open directors list
            case R.id.fragmentCast_directorsLayout:
                //TODO: implement directors layout
                return;
            // Open writers list
            case R.id.fragmentCast_writersLayout:
                //TODO: implement writers layout
                return;
        }
    }
}