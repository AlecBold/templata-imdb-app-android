package com.example.imdbapplication.di.components;

import android.content.Context;

import com.example.imdbapplication.di.components.sub.ActorPageSubComponent;
import com.example.imdbapplication.di.components.sub.MainSubComponent;
import com.example.imdbapplication.di.components.sub.MoviePageSubComponent;
import com.example.imdbapplication.di.components.sub.SearchSubComponent;
import com.example.imdbapplication.di.modules.NetworkModule;
import com.example.imdbapplication.di.modules.StorageModule;
import com.example.imdbapplication.di.modules.SubComponentsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, StorageModule.class, SubComponentsModule.class})
public interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        ApplicationComponent create(@BindsInstance Context context);
    }

    ActorPageSubComponent.Factory actorPageComponent();
    MoviePageSubComponent.Factory moviePageComponent();
    MainSubComponent.Factory mainComponent();
    SearchSubComponent.Factory searchComponent();
}
