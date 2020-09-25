package com.example.imdbapplication.holders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbapplication.R;
import com.example.imdbapplication.databinding.HorizontalItemCardBinding;
import com.example.imdbapplication.pojo.IMDbObject;

public class HorizontalMovieHolder extends RecyclerView.ViewHolder {

    private HorizontalItemCardBinding horizontalItemCardBinding;

    public HorizontalMovieHolder(@NonNull HorizontalItemCardBinding horizontalItemCardBinding) {
        super(horizontalItemCardBinding.getRoot());

        this.horizontalItemCardBinding = horizontalItemCardBinding;
    }

    public HorizontalItemCardBinding getHorizontalItemCardBinding() {
        return horizontalItemCardBinding;
    }
}
