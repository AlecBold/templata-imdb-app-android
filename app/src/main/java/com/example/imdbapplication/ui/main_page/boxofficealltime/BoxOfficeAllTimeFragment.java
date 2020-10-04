package com.example.imdbapplication.ui.main_page.boxofficealltime;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.FragmentRecycleCardsContainerBinding;
import com.example.imdbapplication.pojo.ItemsList;
import com.example.imdbapplication.pojo.movie.Movie;
import com.example.imdbapplication.ui.adapter.MoviesRecycleViewAdapter;
import com.example.imdbapplication.ui.main_page.MainActivity;

import javax.inject.Inject;

public class BoxOfficeAllTimeFragment extends Fragment {
    public static final String TAG = "BoxOfficeAllTimeFragment";
    private MoviesRecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    @Inject
    public BoxOfficeAllTimeViewModel viewModel;

    private TextView title;

    private FragmentRecycleCardsContainerBinding binding;

    public BoxOfficeAllTimeFragment() {
        // Required empty public constructor
    }

    public static BoxOfficeAllTimeFragment newInstance() {
        BoxOfficeAllTimeFragment fragment = new BoxOfficeAllTimeFragment();
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

        title = binding.title;
    }

    private void setData() {
        viewModel.getBoxOfficeAllTime().observe(getActivity(), new Observer<ItemsList<Movie>>() {
            @Override
            public void onChanged(ItemsList<Movie> boxOfficeAllTime) {
                adapter.setMovieList(boxOfficeAllTime.getItems());
            }
        });
        title.setText(R.string.title_box_office_all_time);
    }

}
