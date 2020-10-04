package com.example.imdbapplication.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.example.imdbapplication.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataStorage {
    private static final String TAG = "DataStorage";

    private SharedPreferences sharedPreferences;
    private Context context;

    @Inject
    public DataStorage(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
    }

    public String getApiKey() {
        return sharedPreferences.getString(context.getString(R.string.key_api), "");
    }
}
