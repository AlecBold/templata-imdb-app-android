package com.example.imdbapplication.ui.actor_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.FragmentRecycleCardsContainerBinding;
import com.example.imdbapplication.pojo.casts.FullActor;
import com.example.imdbapplication.ui.actor_page.viewmodel.FullActorViewModel;
import com.example.imdbapplication.ui.adapter.MoviesRecycleViewAdapter;

import javax.inject.Inject;

public class KnownForFragment extends Fragment {
    public static final String TAG = "KnownForFragment";

    private TextView titleView;
    private RecyclerView recyclerView;
    private MoviesRecycleViewAdapter adapter;

    private FragmentRecycleCardsContainerBinding binding;

    @Inject
    public FullActorViewModel viewModel;


    public KnownForFragment() {
    }

    public static KnownForFragment newInstance() {
        KnownForFragment instance = new KnownForFragment();
        return instance;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((ActorPageActivity) requireActivity()).actorPageSubComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycle_cards_container, container, false);
        View view = binding.getRoot();
        initViews();

        Intent intent = getActivity().getIntent();
        String currentIdActor = intent.getStringExtra(ActorPageActivity.KEY_ID_ACTOR);
        setData(currentIdActor);

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
        viewModel.getFullActor(id).observe(getActivity(), new Observer<FullActor>() {
            @Override
            public void onChanged(FullActor fullActor) {
                if (fullActor != null) {
                    adapter.setMovieList(fullActor.getKnownForMovies());
                }
            }
        });
        titleView.setText(R.string.title_known_for);
    }

}
