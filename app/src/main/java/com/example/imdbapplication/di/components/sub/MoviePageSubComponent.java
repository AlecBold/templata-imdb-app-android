package com.example.imdbapplication.di.components.sub;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.ui.movie_page.MoviePageActivity;
import com.example.imdbapplication.ui.movie_page.CastFragment;
import com.example.imdbapplication.ui.movie_page.SimilarMoviesFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface MoviePageSubComponent {

    @Subcomponent.Factory
    interface Factory {
        MoviePageSubComponent create();
    }

    void inject(MoviePageActivity moviePageActivity);
    void inject(SimilarMoviesFragment similarMoviesFragment);
    void inject(CastFragment castFragment);
}
