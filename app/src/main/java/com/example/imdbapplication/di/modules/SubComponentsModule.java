package com.example.imdbapplication.di.modules;

import com.example.imdbapplication.di.components.sub.ActorPageSubComponent;
import com.example.imdbapplication.di.components.sub.MainSubComponent;
import com.example.imdbapplication.di.components.sub.MoviePageSubComponent;
import com.example.imdbapplication.di.components.sub.SearchSubComponent;

import dagger.Module;

@Module(subcomponents = {
        MainSubComponent.class,
        ActorPageSubComponent.class,
        MoviePageSubComponent.class,
        SearchSubComponent.class})
public class SubComponentsModule {
}
