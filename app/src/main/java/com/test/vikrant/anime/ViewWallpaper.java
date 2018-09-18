package com.test.vikrant.anime;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.clans.fab.FloatingActionMenu;
import com.test.vikrant.anime.Common.Common;


import java.io.IOException;

public class ViewWallpaper extends AppCompatActivity {

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);


    FloatingActionMenu mainFloating;

    com.github.clans.fab.FloatingActionButton wall_set;
    ImageView imageView;
    RelativeLayout rootLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_view_wallpaper);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //Init
            rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
            imageView = (ImageView) findViewById(R.id.imageThumb);
            Glide.with(getApplicationContext())
                    .load(Common.select_background.getImageUrl())
                    .into(imageView);

            mainFloating = (FloatingActionMenu) findViewById(R.id.fab);
            wall_set = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab_wall);
            wall_set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Glide.with(getApplicationContext())
                            .load(Common.select_background.getImageUrl())
                            .apply(glideOptions)
                            .into(new SimpleTarget<Drawable>() {

                                @Override
                                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {

                                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                                    Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                                    try {
                                        Snackbar.make(rootLayout, "Wallpaper was set ", Snackbar.LENGTH_SHORT).show();
                                        wallpaperManager.setBitmap(bitmap);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                });
                }
            });
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                finish();
               // navigateUpTo(getIntent().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

