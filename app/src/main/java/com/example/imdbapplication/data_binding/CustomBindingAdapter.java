package com.example.imdbapplication.data_binding;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class CustomBindingAdapter {
    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imgUrl) {
        Glide.with(view.getContext())
                .asBitmap()
                .load(imgUrl)
                .into(view);
    }

    @SuppressLint("CheckResult")
    @BindingAdapter("profileColor")
    public static void loadColor(View view, String imgUrl) {
        Glide.with(view.getContext())
                .asBitmap()
                .load(imgUrl)
                .override(1, 1)
                .listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                view.setBackgroundColor(resource.getPixel(1, 1));
                return false;
            }
        })
        .submit();
    }
}
