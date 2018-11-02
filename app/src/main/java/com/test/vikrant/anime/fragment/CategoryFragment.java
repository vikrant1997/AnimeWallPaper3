package com.test.vikrant.anime.fragment;
<<<<<<< HEAD
import android.app.SearchManager;
import android.content.Context;
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
<<<<<<< HEAD
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
=======
import android.util.Log;
=======

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import com.bumptech.glide.Glide;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

<<<<<<< HEAD
import com.google.firebase.database.Query;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
=======
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import com.test.vikrant.anime.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.vikrant.anime.Interface.ItemClickListener;
<<<<<<< HEAD
import com.test.vikrant.anime.Interface.OnBackPressed;
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import com.test.vikrant.anime.ListWallpaper;
import com.test.vikrant.anime.Model.CategoryItem;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewHolder.CategoryViewHolder;

<<<<<<< HEAD

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
=======
import java.util.Random;

public class CategoryFragment extends Fragment {

    RequestOptions glideOptions = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

    //Firebase
    FirebaseDatabase database;
    DatabaseReference categoryBackground;
<<<<<<< HEAD

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
=======
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
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder
                    , int position, @NonNull final CategoryItem model) {

<<<<<<< HEAD

=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
                Glide.with(getActivity())
                        .load(model.getImageLink())
                        .apply(glideOptions)
                        .into(holder.background_image);
<<<<<<< HEAD

                holder.category_name.setText(model.getName());
                Log.i("CategoryFragment5",model.getImageLink());
                holder.setItemClickListener(new ItemClickListener() {

                    public void onclick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED = adapter.getRef(position).getKey().toString();

                        Common.CATEGORY_SELECTED = model.getName();
                        Intent intent = new Intent(getActivity(), ListWallpaper.class);
=======
                holder.category_name.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int position) {
                        Common.CATEGORY_ID_SELECTED=adapter.getRef(position).getKey();

                        Common.CATEGORY_SELECTED=model.getName();
                        Intent intent=new Intent(getActivity(), ListWallpaper.class);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
                        startActivity(intent);
                    }
                });
            }
<<<<<<< HEAD
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
=======

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
=======
import com.test.vikrant.anime.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);

=======
<<<<<<< HEAD
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

=======
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        setHasOptionsMenu(true);
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.recycler_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
<<<<<<< HEAD
        whiteNotificationBar(recyclerView);
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        setCategory();
        return view;
    }

<<<<<<< HEAD
    private void setCategory() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
=======
private void setCategory(){
        adapter.startListening();
        recyclerView.setAdapter(adapter);
}
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

    @Override
    public void onResume() {
        super.onResume();
<<<<<<< HEAD
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
=======
        if (adapter!=null){
            adapter.startListening();
        }
    }
=======
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        }
    }

    @Override
<<<<<<< HEAD
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

=======
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
}
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
