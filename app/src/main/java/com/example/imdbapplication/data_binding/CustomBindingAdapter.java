package com.example.imdbapplication.data_binding;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomBindingAdapter {
    public static final String TAG = "CustomBindingAdapter";

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imgUrl) {
        Glide.with(view.getContext())
                .asBitmap()
                .load(imgUrl)
                .into(view);
    }

    @BindingAdapter("profileViewVisibility")
    public static void setVisible(View view, boolean v) {
        if (v) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter("visibleIfAllEmpty")
    public static void visibleIfAllEmpty(View view, String... strings) {
        int empties = 0;
        for (String string : strings) {
            if (TextUtils.isEmpty(string)) {
                empties += 1;
            }
        }
        if (empties == strings.length) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}
