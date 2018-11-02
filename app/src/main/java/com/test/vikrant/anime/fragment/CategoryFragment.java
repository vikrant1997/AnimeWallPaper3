package com.test.vikrant.anime.fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.Query;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.test.vikrant.anime.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.Interface.OnBackPressed;
import com.test.vikrant.anime.ListWallpaper;
import com.test.vikrant.anime.Model.CategoryItem;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewHolder.CategoryViewHolder;


import java.util.ArrayList;
import java.util.Random;

public class CategoryFragment extends Fragment implements OnBackPressed {


    private SearchView searchView;
    //private List<CategoryItem> contactList;
    private ArrayList<CategoryItem>contactList;

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_launcher_foreground)
            .dontTransform();

    //Firebase
    FirebaseDatabase database;
    DatabaseReference categoryBackground;

    FirebaseDatabase database2;
    DatabaseReference categoryBackground2;
    Query query;
    //FirebaseUI Adapter
    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerOptions<CategoryItem> options2;
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewHolder> adapter;
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewHolder> firebaseRecyclerAdapter;
    //View
    RecyclerView recyclerView;

    private static CategoryFragment INSTANCE = null;

    public CategoryFragment() {

        database = FirebaseDatabase.getInstance();
        categoryBackground = database.getReference(Common.STR_CATEGORY_BACKGROUND);
         query=categoryBackground.orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);

        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(query, CategoryItem.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder
                    , int position, @NonNull final CategoryItem model) {


                Glide.with(getActivity())
                        .load(model.getImageLink())
                        .apply(glideOptions)
                        .into(holder.background_image);

                holder.category_name.setText(model.getName());
                Log.i("CategoryFragment5",model.getImageLink());
                holder.setItemClickListener(new ItemClickListener() {

                    public void onclick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED = adapter.getRef(position).getKey().toString();

                        Common.CATEGORY_SELECTED = model.getName();
                        Intent intent = new Intent(getActivity(), ListWallpaper.class);
                        startActivity(intent);
                    }
                });
            }
            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_category_item, parent, false);
                return new CategoryViewHolder(itemView);
            }
        };

    }

    private void firebaseSearch(String searchText){

        options2 = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground.orderByChild("name").startAt(searchText).endAt(searchText+"\uf8ff"), CategoryItem.class)
                .build();

        Log.i("CategoryFragment3",options.toString());
        Log.i("CategoryFragment32",options2.toString());

                 firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options2) {

                    protected void onBindViewHolder(@NonNull final CategoryViewHolder holder
                            , int position, @NonNull final CategoryItem model) {

                        Glide.with(getActivity())
                                .load(model.getImageLink())
                                .apply(glideOptions)
                                .into(holder.background_image);

                        holder.category_name.setText(model.getName());
                Log.i("CategoryFragment4",model.getImageLink());

                        holder.setItemClickListener(new ItemClickListener() {

                            public void onclick(View view, int position) {
                                Common.CATEGORY_ID_SELECTED = firebaseRecyclerAdapter.getRef(position).getKey();

                                Common.CATEGORY_SELECTED = model.getName();
                                Intent intent = new Intent(getActivity(), ListWallpaper.class);
                                startActivity(intent);
                            }
                        });

                        // mAdapter.notifyDataSetChanged();
                    }

                    @NonNull
                    @Override
                    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View itemView = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_category_item, parent, false);
                        return new CategoryViewHolder(itemView);
                    }
                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static CategoryFragment getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new CategoryFragment();
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.recycler_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        whiteNotificationBar(recyclerView);
        setCategory();
        return view;
    }

    private void setCategory() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.startListening();
        }
        if (firebaseRecyclerAdapter != null) {
            firebaseRecyclerAdapter.startListening();
        }
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setVisibility(View.VISIBLE);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //recyclerView.setAdapter(firebaseRecyclerAdapter);
                firebaseSearch(query);
                firebaseRecyclerAdapter.startListening();
                Log.i("CategoryFragment2","reached");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                firebaseSearch(query);
                firebaseRecyclerAdapter.startListening();
                return false;
            }

        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }}
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getActivity().getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public boolean OnBackPressed() {
        super.getActivity().onBackPressed();
        if (searchView.isIconified()==true) {
            searchView.setIconified(false);
            //return;

        return true;
        }
        //super.getActivity().onBackPressed();
        return false;
    }
}

