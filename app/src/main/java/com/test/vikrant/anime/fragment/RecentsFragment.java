package com.test.vikrant.anime.fragment;

<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
<<<<<<< HEAD
=======
=======
import android.os.Bundle;
import android.support.v4.app.Fragment;
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import com.test.vikrant.anime.Adapter.BookMarksAdapter;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.ViewWallpaper;
import com.test.vikrant.anime.database.Anime_Model;
import com.test.vikrant.anime.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
public class RecentsFragment extends Fragment implements BookMarksAdapter.ListItemClickListener{
    private static RecentsFragment INSTANCE=null;
    private RecyclerView mRecyclerView;
    private GridLayoutManager GridLayoutManager;
    private List<Anime_Model> animeList;
    private BookMarksAdapter mAnimeAdapter;
    private Context mContext;
    private AppDatabase mDb;
    @Override
    public void setRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }

<<<<<<< HEAD
=======
=======
import com.test.vikrant.anime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentsFragment extends Fragment {


>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    public RecentsFragment() {
        // Required empty public constructor
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    public static RecentsFragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new RecentsFragment();
        return INSTANCE;
    }
<<<<<<< HEAD
=======
=======
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        return inflater.inflate(R.layout.fragment_recents, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_Bookmarks);
        animeList = new ArrayList<>();
       // mErrorMessageDisplay = (TextView) view.findViewById(R.id.tv_error_message_display);
        GridLayoutManager = new GridLayoutManager(mContext,2);
        mContext=getActivity();
        mDb = AppDatabase.getInstance(getActivity());

        mRecyclerView.setLayoutManager(GridLayoutManager);
        //mRecyclerView.setHasFixedSize(true);

        mAnimeAdapter = new BookMarksAdapter(mContext, animeList, this);

        mRecyclerView.setAdapter(mAnimeAdapter);
        retrieveTasks();
    }

    private void retrieveTasks() {
        final LiveData<List<Anime_Model>> tasks = mDb.taskDao().loadAllTasks();
        tasks.observe(this, new Observer<List<Anime_Model>>() {
            @Override
            public void onChanged(@Nullable List<Anime_Model> taskEntries) {
                animeList=taskEntries;
                mAnimeAdapter.setTasks(taskEntries);
            }
        });

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        String msg=String.valueOf(clickedItemIndex);
        Anime_Model obj=animeList.get(clickedItemIndex);

        //WallpaperItem item=animeList.get(clickedItemIndex);
        String starValue;

        //starValue=loadStar(obj.getTitle());
       // starValue=obj.getStarValue();

        String path;

        //    path = mDb.taskDao().getPath(animeList.get(clickedItemIndex).getTitle());
       // path = obj.getImagePath();


        Intent intent=new Intent(mContext,ViewWallpaper.class);
        Log.d("Recents imageUri ",obj.getAnimeUri());
        intent.putExtra("imageUri",obj.getAnimeUri());
        intent.putExtra("imageId",obj.getImageId());
<<<<<<< HEAD
        intent.putExtra("finalPath",obj.getAnimeFinal());
=======
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        startActivity(intent);

        //startActivity(send);

    }
<<<<<<< HEAD
=======
=======
        return inflater.inflate(R.layout.fragment_recents, container, false);
    }

>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
}
