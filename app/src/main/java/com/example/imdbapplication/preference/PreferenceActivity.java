package com.example.imdbapplication.preference;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.imdbapplication.R;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {


        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.prefs, rootKey);
            SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();

            setInfoToSummary(getString(R.string.key_api), sharedPreferences);
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            setInfoToSummary(s, sharedPreferences);
        }

        private void setInfoToSummary(String key, SharedPreferences sharedPreferences) {
            EditTextPreference editTextPreference = findPreference(key);
            if (editTextPreference != null) {
                if (sharedPreferences.getString(key, "").trim().equals("")) {
                    editTextPreference.setSummary(getString(R.string.title_summary_api_key));
                } else {
                    editTextPreference.setSummary(sharedPreferences.getString(key, ""));
                }
            }
        }
    }
}