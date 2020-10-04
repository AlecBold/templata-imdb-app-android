package com.example.imdbapplication.ui.main_page.top250;

import android.content.Context;
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
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.popup.PopUpErrorHelper;
import com.example.imdbapplication.ui.adapter.MoviesRecycleViewAdapter;
import com.example.imdbapplication.ui.main_page.MainActivity;

import javax.inject.Inject;

public class Top250MoviesFragment extends Fragment {
    public static final String TAG = "Top250MoviesFragment";

    private MoviesRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private TextView titleView;

    @Inject
    public Top250MoviesViewModel viewModel;

    private FragmentRecycleCardsContainerBinding binding;

    public Top250MoviesFragment() {
        // Required empty public constructor
    }

    public static Top250MoviesFragment newInstance() {
        Top250MoviesFragment fragment = new Top250MoviesFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((MainActivity) requireActivity()).mainSubComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycle_cards_container, container, false);
        View view = binding.getRoot();
        initViews();
        setData();

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

    private void setData() {
        viewModel.getTop250Movies().observe(getActivity(), new Observer<ItemsList<Movie>>() {
            @Override
            public void onChanged(ItemsList<Movie> movieCardItemsList) {
                if (!PopUpErrorHelper.showToastIfErrorMessage(getActivity(), movieCardItemsList.getErrorMessage())) {
                    adapter.setMovieList(movieCardItemsList.getItems());
                }
            }
        });
        titleView.setText(R.string.title_top250movies);
    }
}