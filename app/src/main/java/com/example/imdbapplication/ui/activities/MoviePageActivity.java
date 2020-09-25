package com.example.imdbapplication.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.load.data.BufferedOutputStream;
import com.example.imdbapplication.R;
import com.example.imdbapplication.data_binding.TrailerClickListener;
import com.example.imdbapplication.databinding.ActivityMoviePageBinding;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.ui.fragments.CastFragment;
import com.example.imdbapplication.ui.fragments.SimilarMoviesFragment;
import com.example.imdbapplication.viewmodels.FullMovieViewModel;

import java.io.IOException;
import java.net.URL;

public class MoviePageActivity extends AppCompatActivity implements TrailerClickListener {
    public static final String TAG = "MoviePageActivity";
    public final static String KEY_ID_MOVIE = "key_id";

    private ActivityMoviePageBinding binding;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_page);
        setupActionBar();

        Fragment castFragment = getSupportFragmentManager().findFragmentByTag(CastFragment.TAG);
        Fragment similarMoviesFragment = getSupportFragmentManager().findFragmentByTag(SimilarMoviesFragment.TAG);

        if (castFragment == null) {
            castFragment = CastFragment.newInstance();
        }
        if (similarMoviesFragment == null) {
            similarMoviesFragment = SimilarMoviesFragment.newInstance();
        }

        replaceFragment(castFragment, R.id.activityMoviePage_castContainer, CastFragment.TAG);
        replaceFragment(similarMoviesFragment, R.id.activityMoviePage_similarMovies, SimilarMoviesFragment.TAG);

        Intent intent = getIntent();
        String id = intent.getStringExtra(KEY_ID_MOVIE);

        FullMovieViewModel viewModel = new ViewModelProvider(this).get(FullMovieViewModel.class);
        viewModel.init(id);

        setData(viewModel);
    }

    private void replaceFragment(@NonNull Fragment fragment, int viewId, @NonNull String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    @Override
    public void onClicked(String urlTrailer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlTrailer));
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setMessage("Open trailer in browser?");
        builder.show();
    }

    private void setData(FullMovieViewModel viewModel) {
        viewModel.getAll().observe(this, new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                binding.setFullMovie(fullMovie);
            }
        });
        binding.setTrailerClickListener(this);
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
