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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.firebase.database.Query;
=======
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
import com.google.firebase.database.Query;
>>>>>>> PaypalAdded
=======
import com.google.firebase.database.Query;
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    Query query;
=======

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
    Query query;
>>>>>>> PaypalAdded
=======
    Query query;
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
       // query=categoryBackground.orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);
=======

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
       // query=categoryBackground.orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);
>>>>>>> PaypalAdded
=======
       // query=categoryBackground.orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);
>>>>>>> master
        options=new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground/*.orderByKey().startAt(String.valueOf(rand)).limitToFirst(5)*/,CategoryItem.class)
                .build();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master
        adapter=new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder
                    , int position, @NonNull final CategoryItem model) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
//                Picasso.get()
//                        .load(model.getImageLink())
//                        .networkPolicy(NetworkPolicy.OFFLINE)
//                        .into(holder.background_image, new Callback() {
//                            @Override
//                            public void onSuccess() {
//
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                Picasso.get()
//                                        .load(model.getImageLink())
//                                        .error(R.drawable.ic_launcher_foreground)
//                                        .into(holder.background_image, new Callback() {
//                                            @Override
//                                            public void onSuccess() {
//
//                                            }
//
//                                            @Override
//                                            public void onError(Exception e) {
//                                                Log.e("ERROR_ANIME","Couldn't fetch image");
//                                            }
//                                        });
//                            }
//                        });
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master

                Glide.with(getActivity())
                        .load(model.getImageLink())
                        .apply(glideOptions)
                        .into(holder.background_image);
                holder.category_name.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int position) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();

                        Common.CATEGORY_SELECTED=model.getName();
=======
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();  //get Key of item
                        Common.CATEGORY_SELECTED=model.getName();

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();

                        Common.CATEGORY_SELECTED=model.getName();
>>>>>>> PaypalAdded
=======
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();

                        Common.CATEGORY_SELECTED=model.getName();
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        };
=======

        };

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
        };
>>>>>>> PaypalAdded
=======
        };
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        // Inflate the layout for this fragment
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (adapter!=null){
//            adapter.startListening();
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (adapter!=null){
//            adapter.stopListening();
//        }
//    }

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master
    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null){
            adapter.startListening();
        }
    }
}
