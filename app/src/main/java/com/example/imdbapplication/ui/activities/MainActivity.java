package com.example.imdbapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.imdbapplication.R;
import com.example.imdbapplication.ui.fragments.FavoritesFragment;
import com.example.imdbapplication.ui.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavView;

//    private AppBarConfiguration appBarConfiguration;
//    private NavController navController;

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if (savedInstanceState == null) {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(FavoritesFragment.TAG);
            if (fragment == null) {
                fragment = FavoritesFragment.newInstance();
            }
            replaceFragment(fragment, FavoritesFragment.TAG);
        }
        bottomNavView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_search_button_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.topSearchButtonMenu_button) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navFavorites:
                fragment = getSupportFragmentManager().findFragmentByTag(FavoritesFragment.TAG);
                if (fragment == null) {
                    fragment = FavoritesFragment.newInstance();
                }
                replaceFragment(fragment, FavoritesFragment.TAG);
                break;
            case R.id.navHome:
                fragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
                if (fragment == null) {
                    fragment = HomeFragment.newInstance();
                }
                replaceFragment(fragment, HomeFragment.TAG);
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean replaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (!fragment.equals(currentFragment)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activityMain_navHostFrame, fragment, tag)
                    .addToBackStack(null)
                    .commit();
            getSupportFragmentManager().executePendingTransactions();
            currentFragment = fragment;
            return true;
        }
        return false;
    }

    private void initViews() {
        bottomNavView = findViewById(R.id.nav_view);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}