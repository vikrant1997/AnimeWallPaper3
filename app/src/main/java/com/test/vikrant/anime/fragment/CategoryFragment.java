package com.test.vikrant.anime.fragment;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.test.vikrant.anime.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.ListWallpaper;
import com.test.vikrant.anime.Model.CategoryItem;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewHolder.CategoryViewHolder;

import java.util.Random;

public class CategoryFragment extends Fragment {

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);

    //Firebase
    FirebaseDatabase database;
    DatabaseReference categoryBackground;
    Query query;
    //FirebaseUI Adapter
    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewHolder> adapter;

    //View
    RecyclerView recyclerView;

    private Random r=new Random();

    private static CategoryFragment INSTANCE =null;
    public CategoryFragment() {
        database=FirebaseDatabase.getInstance();
        categoryBackground= database.getReference(Common.STR_CATEGORY_BACKGROUND);
       // query=categoryBackground.orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);
        options=new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground/*.orderByKey().startAt(String.valueOf(rand)).limitToFirst(5)*/,CategoryItem.class)
                .build();

        adapter=new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder
                    , int position, @NonNull final CategoryItem model) {

                Glide.with(getActivity())
                        .load(model.getImageLink())
                        .apply(glideOptions)
                        .into(holder.background_image);
                holder.category_name.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();

                        Common.CATEGORY_SELECTED=model.getName();
                        Intent intent=new Intent(getActivity(), ListWallpaper.class);
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView=LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_category_item,parent,false);
                return new CategoryViewHolder(itemView);
            }
        };
    }

    public static CategoryFragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new CategoryFragment();
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.recycler_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        setCategory();
        return view;
    }

private void setCategory(){
        adapter.startListening();
        recyclerView.setAdapter(adapter);
}

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null){
            adapter.startListening();
        }
    }
}
