package com.test.vikrant.anime;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
<<<<<<< HEAD
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
=======
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.clans.fab.FloatingActionMenu;
import com.test.vikrant.anime.Common.Common;
<<<<<<< HEAD
import com.test.vikrant.anime.database.Anime_Model;
import com.test.vikrant.anime.database.AppDatabase;
import com.test.vikrant.anime.database.AppExecutors;
=======
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337


import java.io.IOException;

<<<<<<< HEAD
import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class ViewWallpaper extends AppCompatActivity {
    private AppDatabase mDb;
    private int id;
    private String image_path;
    private String image_uri;
    private boolean flag=false;
=======
public class ViewWallpaper extends AppCompatActivity {

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);

<<<<<<< HEAD
=======

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
    FloatingActionMenu mainFloating;

    com.github.clans.fab.FloatingActionButton wall_set;
    ImageView imageView;
    RelativeLayout rootLayout;
<<<<<<< HEAD
    Icon heartImage;
    Drawable drawable;
    private Menu testMenu;
=======


>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_view_wallpaper);
        setSupportActionBar(toolbar);
<<<<<<< HEAD

        Intent fetch=getIntent();
        image_path=fetch.getStringExtra("imageId");
        image_uri=fetch.getStringExtra("imageUri");
//        id=Integer.parseInt(fetch.getStringExtra("id"));
        mDb = AppDatabase.getInstance(getApplicationContext());

        //checkHeart(image_path);
=======
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //Init
            rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
            imageView = (ImageView) findViewById(R.id.imageThumb);
            Glide.with(getApplicationContext())
                    .load(Common.select_background.getImageUrl())
                    .into(imageView);
<<<<<<< HEAD
            Log.d("ViewWallpaper reacehed ","reached ");
            mainFloating = (FloatingActionMenu) findViewById(R.id.fab);
            wall_set = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab_wall);

=======

            mainFloating = (FloatingActionMenu) findViewById(R.id.fab);
            wall_set = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab_wall);
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
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
<<<<<<< HEAD
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_wallpaper_menu, menu);
        testMenu=menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String heart_fav=getResources().getResourceEntryName(R.id.heart_fav);

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.heart_fav:

                if(flag==false){
                    Anime_Model taskEntry = new Anime_Model(image_uri, image_path);
                    insertItem(taskEntry);
                    flag=true;
                }
                else {
                    deleteById(image_path);
                    flag=false;
                }
                Toast.makeText(getApplicationContext(),String.valueOf(flag),Toast.LENGTH_SHORT).show();
                return true;

        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        invalidateOptionsMenu();
        checkHeart(image_path);
        Log.i("onprepare ",String.valueOf(flag));
        if(flag){
            menu.findItem(R.id.heart_fav).setIcon(R.drawable.ic_heart_full);
        }
        else menu.findItem(R.id.heart_fav).setIcon(R.drawable.ic_heart_empty);

        return true;
    }

    public void insertItem(final Anime_Model taskAnime){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.taskDao().insertTask(taskAnime);
                //Toast.makeText(getApplicationContext(),"item inserted ",Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void checkHeart(final String image_path){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {

                if(mDb.taskDao().checkHeart(image_path)!=null) {
                    flag=true;
                }
            }
        });
        Log.i("taskDao check ",String.valueOf(flag)+" "+image_path);
    }
public void deleteById(final String mImagePath){
    AppExecutors.getInstance().diskIO().execute(new Runnable() {
        @Override
        public void run() {
            mDb.taskDao().delteById(mImagePath);
//            Toast.makeText(getApplicationContext(),"item deleted ",Toast.LENGTH_SHORT).show();
//            finish();
        }
    });
}

=======


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
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
}

