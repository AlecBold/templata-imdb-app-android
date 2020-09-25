package com.example.imdbapplication.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imdbapplication.R;

public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";

    private Top250MoviesFragment top250MoviesFragment;
    private ComingSoonFragment comingSoonFragment;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Fragment top250MoviesFragment = getChildFragmentManager().findFragmentByTag(Top250MoviesFragment.TAG);
        Fragment comingSoonFragment = getChildFragmentManager().findFragmentByTag(ComingSoonFragment.TAG);

        if (top250MoviesFragment == null) {
            top250MoviesFragment = Top250MoviesFragment.newInstance();
        }
        if (comingSoonFragment == null) {
            comingSoonFragment = ComingSoonFragment.newInstance();
        }

        replaceFragment(top250MoviesFragment, R.id.homeFragment_top250Movies_container, Top250MoviesFragment.TAG);
        replaceFragment(comingSoonFragment, R.id.homeFragment_comingSoon_container, ComingSoonFragment.TAG);

//        if (savedInstanceState != null) {
//            top250MoviesFragment = (Top250MoviesFragment) getChildFragmentManager().getFragment(savedInstanceState, Top250MoviesFragment.TAG);
//            comingSoonFragment = (ComingSoonFragment) getChildFragmentManager().getFragment(savedInstanceState, ComingSoonFragment.TAG);
//            Log.d(TAG, "onCreateView recover instance");
//        } else {
//            top250MoviesFragment = Top250MoviesFragment.newInstance();
//            comingSoonFragment = ComingSoonFragment.newInstance();
//        }
//        replaceFragment(top250MoviesFragment, R.id.homeFragment_top250Movies_container);
//        replaceFragment(comingSoonFragment, R.id.homeFragment_comingSoon_container);
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

//        getChildFragmentManager().putFragment(outState, Top250MoviesFragment.TAG, top250MoviesFragment);
//        getChildFragmentManager().putFragment(outState, ComingSoonFragment.TAG, comingSoonFragment);
    }
    private void replaceFragment(@NonNull Fragment fragment, int viewId, @NonNull String tag) {
        getChildFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}