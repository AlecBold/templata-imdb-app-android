# IMDb Clone
IMDb app using IMDb Api in Android/Java with MVVM architecture.

## Built with
* [Dagger 2](https://dagger.dev/) - Dependency Injection Framework
* [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
* [Data Binding Library](https://developer.android.com/topic/libraries/data-binding) - allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/) - Collection of libraries that help you design robust, testable, and maintainable apps.
* [Shared Preferences](https://developer.android.com/reference/android/content/SharedPreferences) - Interface for accessing and modifying preference data.


## App Structure
```
.
├── data
│   └── DataStorage.java
├── di
│   ├── components
│   │   ├── ApplicationComponent.java
│   │   └── sub
│   │       ├── ActorPageSubComponent.java
│   │       ├── MainSubComponent.java
│   │       ├── MoviePageSubComponent.java
│   │       └── SearchSubComponent.java
│   ├── modules
│   │   ├── NetworkModule.java
│   │   ├── RepositoryModule.java
│   │   ├── StorageModule.java
│   │   └── SubComponentsModule.java
│   └── scopes
│       ├── ActivityScope.java
│       └── FragmentScope.java
├── IMDBApplication.java
├── network
│   └── IMDbApi.java
├── pojo
│   ├── casts
│   │   ├── Actor.java
│   │   ├── FullActor.java
│   │   └── FullCast.java
│   ├── Image.java
│   ├── IMDbObject.java
│   ├── ItemsList.java
│   ├── movie
│   │   ├── FullMovie.java
│   │   ├── Movie.java
│   │   └── SearchedMovie.java
│   ├── ResultList.java
│   ├── Trailer.java
│   └── Wikipedia.java
├── popup
│   └── PopUpErrorHelper.java
├── repository
│   └── IMDbRepository.java
├── ui
│   ├── actor_page
│   │   ├── ActorPageActivity.java
│   │   ├── KnownForFragment.java
│   │   └── viewmodel
│   │       └── FullActorViewModel.java
│   ├── adapter
│   │   ├── ActorsRecycleViewAdapter.java
│   │   ├── MoviesRecycleViewAdapter.java
│   │   └── SearchListRecycleViewAdapter.java
│   ├── main_page
│   │   ├── boxoffice
│   │   │   ├── BoxOfficeFragment.java
│   │   │   └── BoxOfficeViewModel.java
│   │   ├── boxofficealltime
│   │   │   ├── BoxOfficeAllTimeFragment.java
│   │   │   └── BoxOfficeAllTimeViewModel.java
│   │   ├── comingsoon
│   │   │   ├── ComingSoonFragment.java
│   │   │   └── ComingSoonMoviesViewModel.java
│   │   ├── intheaters
│   │   │   ├── InTheatersFragment.java
│   │   │   └── InTheatersViewModel.java
│   │   ├── MainActivity.java
│   │   ├── mostpopularmovies
│   │   │   ├── MostPopularMoviesFragment.java
│   │   │   └── MostPopularsMovieViewModel.java
│   │   └── top250
│   │       ├── Top250MoviesFragment.java
│   │       └── Top250MoviesViewModel.java
│   ├── movie_page
│   │   ├── CastFragment.java
│   │   ├── MoviePageActivity.java
│   │   ├── SimilarMoviesFragment.java
│   │   └── viewmodel
│   │       └── FullMovieViewModel.java
│   ├── preference
│   │   └── PreferenceActivity.java
│   └── search_page
│       ├── SearchActivity.java
│       └── viewmodel
│           └── SearchViewModel.java
└── utils
    ├── ApiKeyValidator.java
    ├── CustomBindingAdapter.java
    ├── DatabaseUtil.java
    ├── IMDbUtil.java
    └── listeners
        ├── CardClickListener.java
        ├── TrailerClickListener.java
        └── WikiClickListener.java

```
## Credits
* Data from [IMDb Api](https://imdb-api.com/)
