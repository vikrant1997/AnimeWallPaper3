package com.test.vikrant.anime.BottomBar;

<<<<<<< HEAD
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
=======
<<<<<<< HEAD
import android.content.Intent;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.ListWallpaper;
import com.test.vikrant.anime.Model.CategoryItem;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewHolder.BottomCategoryViewHolder;

public class Bottom_List_Category extends Fragment {

    private static Bottom_List_Category INSTANCE=null;

   private RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
           .centerCrop()
            .error(R.drawable.ic_launcher_foreground);

    //Firebase
   private FirebaseDatabase database;
    private DatabaseReference categoryBackground;

    //FirebaseUI Adapter
   private FirebaseRecyclerOptions<CategoryItem> options;
    private FirebaseRecyclerAdapter<CategoryItem,BottomCategoryViewHolder> adapter;

    //View
    RecyclerView recyclerView;

    public static Bottom_List_Category getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new Bottom_List_Category();
        return INSTANCE;
    }

    public Bottom_List_Category() {
        database=FirebaseDatabase.getInstance();
        categoryBackground= database.getReference(Common.STR_CATEGORY_BACKGROUND);

        options=new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground,CategoryItem.class)
                .build();

        adapter=new FirebaseRecyclerAdapter<CategoryItem, BottomCategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final BottomCategoryViewHolder holder
                    , int position, @NonNull final CategoryItem model) {
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

//                Glide.with(getActivity())
//                        .load(model.getImageLink())
//                        .apply(glideOptions)
//                        .into(holder.background_image);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
                holder.category_id.setText(position+1+".");
                holder.category_name.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();  //get Key of item
                        Common.CATEGORY_SELECTED=model.getName();

                        Intent intent=new Intent(getActivity(), ListWallpaper.class);
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public BottomCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView=LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_bottom_category,parent,false);
                return new BottomCategoryViewHolder(itemView);
            }
        };
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
<<<<<<< HEAD
        setHasOptionsMenu(false);
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        setHasOptionsMenu(false);
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        View view = inflater.inflate(R.layout.content_bottom_category, container, false);
        recyclerView = view.findViewById(R.id.recycler_bottom_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
<<<<<<< HEAD
        whiteNotificationBar(recyclerView);
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        setCategory();
        return view;
    }

    private void setCategory(){
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
<<<<<<< HEAD
    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getActivity().getWindow().setStatusBarColor(Color.WHITE);
        }
    }

}
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
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (adapter!=null){
//            adapter.startListening();
//        }
//    }
}
=======
public class Bottom_List_Category {
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
