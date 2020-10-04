package com.example.imdbapplication.di.components.sub;

import com.example.imdbapplication.di.scopes.ActivityScope;
import com.example.imdbapplication.ui.actor_page.ActorPageActivity;
import com.example.imdbapplication.ui.actor_page.KnownForFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface ActorPageSubComponent {

    @Subcomponent.Factory
    interface Factory {
        ActorPageSubComponent create();
    }

    void inject(ActorPageActivity actorPageActivity);
    void inject(KnownForFragment knownForFragment);
}
