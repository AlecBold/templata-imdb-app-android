package com.example.imdbapplication.ui.main_page;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.imdbapplication.IMDBApplication;
import com.example.imdbapplication.R;
import com.example.imdbapplication.di.components.sub.MainSubComponent;
import com.example.imdbapplication.preference.ApiKeyValidator;
import com.example.imdbapplication.preference.PreferenceActivity;
import com.example.imdbapplication.ui.main_page.boxoffice.BoxOfficeFragment;
import com.example.imdbapplication.ui.main_page.boxofficealltime.BoxOfficeAllTimeFragment;
import com.example.imdbapplication.ui.main_page.comingsoon.ComingSoonFragment;
import com.example.imdbapplication.ui.main_page.intheaters.InTheatersFragment;
import com.example.imdbapplication.ui.main_page.mostpopularmovies.MostPopularMoviesFragment;
import com.example.imdbapplication.ui.main_page.top250.Top250MoviesFragment;
import com.example.imdbapplication.ui.search_page.SearchActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "MainActivity";

    private SwipeRefreshLayout swipeRefreshLayout;

    public MainSubComponent mainSubComponent;

    @Inject
    public ApiKeyValidator apiKeyValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainSubComponent = ((IMDBApplication) getApplication()).getAppComponent().mainComponent().create();
        mainSubComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if (savedInstanceState == null) {
            Fragment top250MoviesFragment = getSupportFragmentManager().findFragmentByTag(Top250MoviesFragment.TAG);
            Fragment comingSoonFragment = getSupportFragmentManager().findFragmentByTag(ComingSoonFragment.TAG);
            Fragment mostPopularMoviesFragment = getSupportFragmentManager().findFragmentByTag(MostPopularMoviesFragment.TAG);
            Fragment inTheatersFragment = getSupportFragmentManager().findFragmentByTag(InTheatersFragment.TAG);

            if (top250MoviesFragment == null) {
                top250MoviesFragment = Top250MoviesFragment.newInstance();
            }
            if (comingSoonFragment == null) {
                comingSoonFragment = ComingSoonFragment.newInstance();
            }
            if (mostPopularMoviesFragment == null) {
                mostPopularMoviesFragment = MostPopularMoviesFragment.newInstance();
            }
            if (inTheatersFragment == null) {
                inTheatersFragment = InTheatersFragment.newInstance();
            }

            replaceFragment(top250MoviesFragment, R.id.top250Movies_container, Top250MoviesFragment.TAG);
            replaceFragment(comingSoonFragment, R.id.comingSoon_container, ComingSoonFragment.TAG);
            replaceFragment(mostPopularMoviesFragment, R.id.mostPopularMovies_container, MostPopularMoviesFragment.TAG);
            replaceFragment(inTheatersFragment, R.id.inTheaters_container, InTheatersFragment.TAG);
        }
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initViews() {
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
    }

    private void replaceFragment(@NonNull Fragment fragment, int viewId, @NonNull String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .addToBackStack(null)
                .commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (!apiKeyValidator.isApiKeySet()) {
            showDialogApiValidation();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.mainMenu_searchBtn:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.mainMenu_settingsBtn:
                intent = new Intent(this, PreferenceActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onRefresh() {
        refreshActivity();
    }

    protected void refreshActivity() {
        Intent intent = getIntent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void showDialogApiValidation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_imDb_api)));
                startActivity(intent);
            }
        });
        builder.setMessage(R.string.question_for_api_key);
        builder.show();
    }
}