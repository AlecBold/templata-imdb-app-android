package com.example.imdbapplication.di.components.sub;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.ui.search_page.SearchActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface SearchSubComponent {

    @Subcomponent.Factory
    interface Factory {
        SearchSubComponent create();
    }

    void inject(SearchActivity searchActivity);
}
