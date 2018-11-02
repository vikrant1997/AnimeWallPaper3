package com.test.vikrant.anime.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.Model.WallpaperItem;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewHolder.ListWallpaperViewHolder;
import com.test.vikrant.anime.ViewWallpaper;

public class TrendingFragment extends Fragment {

    private static TrendingFragment INSTANCE=null;

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_launcher_foreground)
            .dontTransform();

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference categoryBackground;

    FirebaseRecyclerOptions<WallpaperItem> options,options2;
    FirebaseRecyclerAdapter<WallpaperItem,ListWallpaperViewHolder>adapter;

    public TrendingFragment() {

        database=FirebaseDatabase.getInstance();
        //categoryBackground=database.getReference(Common.STR_WALLPAPER+"1");
        categoryBackground=database.getReference().child("Popular");

        Query query=categoryBackground.orderByChild("viewCount")
                .limitToLast(10);
       // Query query2=database.getReference(Common.STR_WALLPAPER+"2").orderByChild("viewCount").limitToLast(10);
        options=new FirebaseRecyclerOptions.Builder<WallpaperItem>()
                .setQuery(query,WallpaperItem.class)
               // .setQuery(query2,WallpaperItem.class)
                .build();

        adapter=new FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ListWallpaperViewHolder holder
                    , int position, @NonNull final WallpaperItem model) {

                Glide.with(getActivity())
                        .load(model.getImageUrl())
                        .apply(glideOptions)
//                        .thumbnail(0.01f)
                        .into(holder.wallpaper);

                holder.setItemClickListener(new ItemClickListener() {

                    @Override
                    public void onclick(View view, int position) {

                        Intent intent=new Intent(getActivity(), ViewWallpaper.class);
                        Common.select_background=model;

                        //intent.putExtra("id",model.getCategoryId());
                        intent.putExtra("imageUri",model.getImageUrl());
                        intent.putExtra("imageId",model.getImagePath());
                        intent.putExtra("Uniqid","DailyPopular");
                        Common.select_background_key=adapter.getRef(position).getKey();
                       // Log.d("ListWall image_fi ",model.getImageFinal());
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
//        adapter.startListening();
//        recyclerView.setAdapter(adapter);
    }

    public static TrendingFragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new TrendingFragment();
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_daily_popular, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_popular);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);

       // gridLayoutManager.setStackFromEnd(true);
        gridLayoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(gridLayoutManager);

        loadPopularList();

        return view;
    }

    private void loadPopularList(){
        //adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null){
            adapter.startListening();
        }
    }
}
