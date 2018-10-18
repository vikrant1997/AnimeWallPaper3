package com.test.vikrant.anime;

<<<<<<< HEAD
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseArray;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import com.google.firebase.database.ValueEventListener;
import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.Model.WallpaperItem;
import com.test.vikrant.anime.ViewHolder.ListWallpaperViewHolder;

import java.util.ArrayList;

public class ListWallpaper extends AppCompatActivity{

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);

    Query query;
    FirebaseRecyclerOptions<WallpaperItem> options;
    FirebaseRecyclerAdapter<WallpaperItem,ListWallpaperViewHolder> adapter;

    RecyclerView recyclerView;
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListWallpaper extends AppCompatActivity {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wallpaper);
<<<<<<< HEAD

        Toolbar toolbar=(Toolbar) findViewById(R.id.list_toolbar);
        toolbar.setTitle(Common.CATEGORY_SELECTED);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView=findViewById(R.id.recycler_list_wallpaper);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        loadBackgroundList();

    }

    private void loadBackgroundList(){

        query= FirebaseDatabase.getInstance().getReference(Common.STR_WALLPAPER)
        .orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);


        options=new FirebaseRecyclerOptions.Builder<WallpaperItem>()
                .setQuery(query,WallpaperItem.class)
                .build();




        adapter=new FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ListWallpaperViewHolder holder
                    , int position, @NonNull final WallpaperItem model) {


                Glide.with(getApplicationContext())
                        .load(model.getImageUrl())
                        .apply(glideOptions)
                        .into(holder.wallpaper);
                holder.setItemClickListener(new ItemClickListener() {

                    @Override
                    public void onclick(View view, int position) {

                        Intent intent=new Intent(getApplicationContext(), ViewWallpaper.class);
                        Common.select_background=model;


                        //intent.putExtra("id",model.getCategoryId());
                        intent.putExtra("imageUri",model.getImageUrl());
                        intent.putExtra("imageId",model.getImagePath());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public ListWallpaperViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_list_wallpaper_item, parent, false);
                int height = parent.getHeight()/2;
                itemView.setMinimumHeight(height);
                return new ListWallpaperViewHolder(itemView);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter!=null){
            adapter.startListening();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                //NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
=======
    }
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
