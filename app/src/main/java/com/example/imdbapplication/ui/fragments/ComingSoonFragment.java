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
import com.example.imdbapplication.adapter.ComingSoonListRecycleViewAdapter;
import com.example.imdbapplication.databinding.FragmentComingSoonBinding;
import com.example.imdbapplication.pojo.movie.ComingMovie;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.ui.activities.AllMoviesActivity;
import com.example.imdbapplication.viewmodels.ComingSoonMoviesViewModel;

public class ComingSoonFragment extends Fragment {
    public static final String TAG = "ComingSoonFragment";

    private ComingSoonListRecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    private ComingSoonMoviesViewModel viewModel;

    private Button btnAll;
    private TextView title;

    private FragmentComingSoonBinding binding;

    public ComingSoonFragment() {
        // Required empty public constructor
    }
    public static ComingSoonFragment newInstance() {
        ComingSoonFragment fragment = new ComingSoonFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_coming_soon, container, false);
        View view = binding.getRoot();
        initViews();

        adapter = new ComingSoonListRecycleViewAdapter(getActivity(), R.layout.horizontal_item_card);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(getActivity()).get(ComingSoonMoviesViewModel.class);
        viewModel.init();

        setData();

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllMoviesActivity.class);
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
        recyclerView = binding.comingSoonRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        btnAll = binding.comingSoonBtnSeeAll.btnAll;
        title = binding.comingSoonTitle;
    }

    private void setData() {
        viewModel.getAll().observe(getActivity(), new Observer<ItemsList<ComingMovie>>() {
            @Override
            public void onChanged(ItemsList<ComingMovie> comingSoonMovieItemsList) {
                Log.d(TAG, "onChanged: set");
                adapter.setComingSoonMovieList(comingSoonMovieItemsList.getItems());
            }
        });
    }
}