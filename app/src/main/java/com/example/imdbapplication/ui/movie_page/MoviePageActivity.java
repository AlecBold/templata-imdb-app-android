package com.example.imdbapplication.ui.movie_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.imdbapplication.IMDBApplication;
import com.example.imdbapplication.R;
import com.example.imdbapplication.listeners.TrailerClickListener;
import com.example.imdbapplication.listeners.WikiClickListener;
import com.example.imdbapplication.databinding.ActivityMoviePageBinding;
import com.example.imdbapplication.di.components.sub.MoviePageSubComponent;
import com.example.imdbapplication.pojo.movie.FullMovie;
import com.example.imdbapplication.popup.PopUpErrorHelper;
import com.example.imdbapplication.ui.movie_page.viewmodel.FullMovieViewModel;
import com.google.android.material.appbar.MaterialToolbar;

import javax.inject.Inject;

public class MoviePageActivity extends AppCompatActivity implements TrailerClickListener, WikiClickListener {
    public static final String TAG = "MoviePageActivity";
    public final static String KEY_ID_MOVIE = "key_id";

    @Inject
    public FullMovieViewModel viewModel;

    public MoviePageSubComponent moviePageSubComponent;

    private ActivityMoviePageBinding binding;

    private MaterialToolbar toolbar;

    private String currentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        moviePageSubComponent = ((IMDBApplication) getApplication()).getAppComponent().moviePageComponent().create();
        moviePageSubComponent.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_page);
        initViews();
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
        currentId = intent.getStringExtra(KEY_ID_MOVIE);

        setData();
    }

    private void replaceFragment(@NonNull Fragment fragment, int viewId, @NonNull String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    @Override
    public void onTrailerClick(String urlTrailer) {
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
        builder.setMessage(R.string.question_open_trailer);
        builder.show();
    }

    @Override
    public void onWikiClick(String wikiUrl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikiUrl));
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setMessage(R.string.question_open_wiki);
        builder.show();
    }

    private void setData() {
        viewModel.getFullMovie(currentId).observe(this, new Observer<FullMovie>() {
            @Override
            public void onChanged(FullMovie fullMovie) {
                if (fullMovie != null &&
                        !PopUpErrorHelper.showToastIfErrorMessage(MoviePageActivity.this, fullMovie.getErrorMessage())) {
                    binding.setFullMovie(fullMovie);
                    binding.setWikiClickListener(MoviePageActivity.this);
                    binding.progressBar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MoviePageActivity.this, R.string.error_connection_problem, Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });
        binding.setTrailerClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void initViews() {
        toolbar = binding.toolbar;
    }
}
