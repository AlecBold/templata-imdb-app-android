package com.example.imdbapplication;

import android.app.Application;

import com.example.imdbapplication.di.components.ApplicationComponent;
import com.example.imdbapplication.di.components.DaggerApplicationComponent;

public class IMDBApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.factory().create(getApplicationContext());
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
