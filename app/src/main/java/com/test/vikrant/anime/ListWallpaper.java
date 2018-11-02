package com.test.vikrant.anime;

import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.Model.WallpaperItem;
import com.test.vikrant.anime.ViewHolder.ListWallpaperViewHolder;

public class ListWallpaper extends AppCompatActivity{

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_launcher_foreground)
            .dontTransform();

    Query query,query2;
    FirebaseRecyclerOptions<WallpaperItem> options;
    FirebaseRecyclerAdapter<WallpaperItem,ListWallpaperViewHolder> adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_wallpaper);

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
         query=FirebaseDatabase.getInstance().getReference(Common.STR_WALLPAPER+Common.CATEGORY_ID_SELECTED);
        options =new FirebaseRecyclerOptions.Builder<WallpaperItem>()
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

                        intent.putExtra("imageUri",model.getImageUrl());
                        intent.putExtra("imageId",model.getImagePath());
                        //Common.select_background_key=adapter.getRef(position).getKey();
                        Log.d("ListWall image_fi ",model.getImageFinal());
                        intent.putExtra("finalPath",model.getImageFinal());
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
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}