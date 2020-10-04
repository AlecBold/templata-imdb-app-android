package com.example.imdbapplication.di.components.sub;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.ui.main_page.MainActivity;
import com.example.imdbapplication.ui.main_page.boxoffice.BoxOfficeFragment;
import com.example.imdbapplication.ui.main_page.boxofficealltime.BoxOfficeAllTimeFragment;
import com.example.imdbapplication.ui.main_page.comingsoon.ComingSoonFragment;
import com.example.imdbapplication.ui.main_page.intheaters.InTheatersFragment;
import com.example.imdbapplication.ui.main_page.mostpopularmovies.MostPopularMoviesFragment;
import com.example.imdbapplication.ui.main_page.top250.Top250MoviesFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {})
public interface MainSubComponent {
  
  @Subcomponent.Factory
  interface Factory {
    MainSubComponent create();
  }

  void inject(MainActivity mainActivity);
  void inject(Top250MoviesFragment top250MoviesFragment);
  void inject(ComingSoonFragment comingSoonFragment);
  void inject(InTheatersFragment inTheatersFragment);
  void inject(MostPopularMoviesFragment mostPopularMoviesFragment);
  void inject(BoxOfficeFragment boxOfficeFragment);
  void inject(BoxOfficeAllTimeFragment boxOfficeAllTimeFragment);
}
