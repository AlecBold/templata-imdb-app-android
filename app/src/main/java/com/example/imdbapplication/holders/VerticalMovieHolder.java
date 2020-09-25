package com.example.imdbapplication.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.VerticalItemCardBinding;

public class VerticalMovieHolder extends RecyclerView.ViewHolder {

    private VerticalItemCardBinding verticalItemCardBinder;

    public VerticalMovieHolder(@NonNull VerticalItemCardBinding verticalItemCardBinding) {
        super(verticalItemCardBinding.getRoot());

        this.verticalItemCardBinder = verticalItemCardBinding;
    }

    public VerticalItemCardBinding getVerticalItemCardBinder() {
        return verticalItemCardBinder;
    }
}
