package com.test.vikrant.anime;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
<<<<<<< HEAD
import android.support.v4.widget.CircularProgressDrawable;
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.bumptech.glide.Glide;
<<<<<<< HEAD
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.Model.WallpaperItem;
=======
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.clans.fab.FloatingActionMenu;
import com.test.vikrant.anime.Common.Common;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import com.test.vikrant.anime.database.Anime_Model;
import com.test.vikrant.anime.database.AppDatabase;
import com.test.vikrant.anime.database.AppExecutors;


import java.io.IOException;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class ViewWallpaper extends AppCompatActivity {
    private AppDatabase mDb;
    private int id;
    private String image_path;
    private String image_uri;
<<<<<<< HEAD
    private String image_final;
    private boolean flag=false;
    CircularProgressDrawable circle;
    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);
    RequestOptions glideOptions2;

    FloatingActionMenu mainFloating;


=======
    private boolean flag=false;
    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);

    FloatingActionMenu mainFloating;

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    com.github.clans.fab.FloatingActionButton wall_set;
    ImageView imageView;
    RelativeLayout rootLayout;
    Icon heartImage;
    Drawable drawable;
    private Menu testMenu;
<<<<<<< HEAD
=======
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewWallpaper extends AppCompatActivity {

>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);
<<<<<<< HEAD

        circle=new CircularProgressDrawable(this);
        circle.setStrokeWidth(5f);
        circle.setCenterRadius(30f);;
        circle.start();
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_view_wallpaper);
        setSupportActionBar(toolbar);

        Intent fetch=getIntent();
        image_path=fetch.getStringExtra("imageId");
        image_uri=fetch.getStringExtra("imageUri");
<<<<<<< HEAD
        image_final=fetch.getStringExtra("finalPath");
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
//        id=Integer.parseInt(fetch.getStringExtra("id"));
        mDb = AppDatabase.getInstance(getApplicationContext());

        //checkHeart(image_path);
<<<<<<< HEAD
         glideOptions2= new RequestOptions()
                .placeholder(circle)
                .error(R.drawable.ic_launcher_foreground);

=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //Init
            rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
            imageView = (ImageView) findViewById(R.id.imageThumb);
            Glide.with(getApplicationContext())
                    //.load(Common.select_background.getImageUrl())
<<<<<<< HEAD
                    .load(image_final)
                    .apply(glideOptions2)
                    .into(imageView);




=======
                    .load(image_uri)
                    .into(imageView);
            Log.d("ViewWallpaper imageUri ",image_uri);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
            mainFloating = (FloatingActionMenu) findViewById(R.id.fab);
            wall_set = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab_wall);

            wall_set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Glide.with(getApplicationContext())
                            //.load(Common.select_background.getImageUrl())
<<<<<<< HEAD
                            .load(image_final)
=======
                            .load(image_uri)
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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
<<<<<<< HEAD
=======

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    }
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
<<<<<<< HEAD
                    Anime_Model taskEntry = new Anime_Model(image_uri, image_path,image_final);
=======
                    Anime_Model taskEntry = new Anime_Model(image_uri, image_path);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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
<<<<<<< HEAD

                Intent fetch=getIntent();
                String strdata = fetch.getExtras().getString("Uniqid");

                if(strdata!=null&&strdata.equals("DailyPopular")){
                    insertViewCount();
                }
                //insertViewCount();
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
                //Toast.makeText(getApplicationContext(),"item inserted ",Toast.LENGTH_SHORT).show();
            }

        });
    }

<<<<<<< HEAD
    private void insertViewCount() {
        FirebaseDatabase.getInstance()
                .getReference("Popular")
                .child(Common.select_background_key)
        .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("viewCount")) {
                    WallpaperItem wallpaperItem = dataSnapshot.getValue(WallpaperItem.class);
                    long count = wallpaperItem.getViewCount() + 1;
                    Map<String, Object> update_view = new HashMap<>();
                    update_view.put("viewCount", count);
                    FirebaseDatabase.getInstance()
                            .getReference("Popular")
                            .child(Common.select_background_key)
                            .updateChildren(update_view)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(ViewWallpaper.this, "Cannot update view count", Toast.LENGTH_SHORT).show();

                                }
                            });

                }
                else{
                    Map<String, Object> update_view = new HashMap<>();
                    update_view.put("viewCount", Long.valueOf(1));
                    FirebaseDatabase.getInstance()
                            .getReference("Popular")
                            .child(Common.select_background_key)
                            .updateChildren(update_view)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(ViewWallpaper.this, "Cannot set default view count", Toast.LENGTH_SHORT).show();

                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ;
    }

=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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

}

<<<<<<< HEAD
=======
=======
    }
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
