package com.example.imdbapplication.ui.actor_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.imdbapplication.IMDBApplication;
import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.ActivityActorPageBinding;
import com.example.imdbapplication.di.components.sub.ActorPageSubComponent;
import com.example.imdbapplication.pojo.casts.FullActor;
import com.example.imdbapplication.popup.PopUpErrorHelper;
import com.example.imdbapplication.ui.actor_page.viewmodel.FullActorViewModel;
import com.google.android.material.appbar.MaterialToolbar;

import javax.inject.Inject;

public class ActorPageActivity extends AppCompatActivity {
    public static final String TAG = "ActorPageActivity";
    public static final String KEY_ID_ACTOR = "key_id_actor";

    @Inject
    public FullActorViewModel viewModel;

    public ActorPageSubComponent actorPageSubComponent;

    private ActivityActorPageBinding binding;

    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        actorPageSubComponent = ((IMDBApplication) getApplication()).getAppComponent().actorPageComponent().create();
        actorPageSubComponent.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actor_page);
        initViews();
        setupActionBar();

        Fragment knownForFragment = getSupportFragmentManager().findFragmentByTag(KnownForFragment.TAG);
        if (knownForFragment == null) {
            knownForFragment = KnownForFragment.newInstance();
        }
        replaceFragment(knownForFragment, R.id.activityActorPage_knownFors, KnownForFragment.TAG);

        Intent intent = getIntent();
        String currentId = intent.getStringExtra(KEY_ID_ACTOR);
        setData(currentId);
    }

    private void replaceFragment(@NonNull Fragment fragment, int viewId, @NonNull String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    private void initViews() {
        toolbar = binding.toolbar;
    }

    private void setData(String id) {
        viewModel.getFullActor(id).observe(this, new Observer<FullActor>() {
            @Override
            public void onChanged(FullActor fullActor) {
                if (fullActor != null &&
                        !PopUpErrorHelper.showToastIfErrorMessage(ActorPageActivity.this, fullActor.getErrorMessage())) {
                    binding.setFullActor(fullActor);
                    binding.progressBar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(ActorPageActivity.this, R.string.error_connection_problem, Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}