package com.test.vikrant.anime.Adapter;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.vikrant.anime.R;
import com.test.vikrant.anime.database.Anime_Model;
import com.test.vikrant.anime.database.AppDatabase;


import java.util.List;

public class BookMarksAdapter extends RecyclerView.Adapter<BookMarksAdapter.NumberViewHolder> {

    RequestOptions options;
    private Context mContext;
    private static final String TAG = BookMarksAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;

    private AppDatabase mDb;

    private List<Anime_Model> mListItems;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    // COMPLETED (4) Add a ListItemClickListener as a parameter to the constructor and store it in mOnClickListener

    public BookMarksAdapter(Context mContext, List list, BookMarksAdapter.ListItemClickListener listener) {
        mOnClickListener = listener;
        this.mContext = mContext;
        this.mListItems = list;
        mDb = AppDatabase.getInstance(mContext);
        options = new RequestOptions().fitCenter().centerCrop().placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground);
        // options.format(DecodeFormat.PREFER_RGB_565);

    }

    public void setTasks(List<Anime_Model> taskEntries) {
        mListItems = taskEntries;
        notifyDataSetChanged();
    }

    public void getTaskStarValue(List<Anime_Model> taskEntries) {

    }

    public void remove(List<Anime_Model> item) {
        int position = mListItems.indexOf(item);
        mListItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public BookMarksAdapter.NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.layout_list_wallpaper_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        return new BookMarksAdapter.NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookMarksAdapter.NumberViewHolder holder, int position) {

        // holder.mTitle.setText(mListItems.get(position).getTitle());
        if (mDb != null) {
            //String path = mDb.taskDao().getPath(mListItems.get(position).getTitle());
            String path = mListItems.get(position).getAnimeUri();
           // holder.mTitle.setText(mListItems.get(position).getTitle());
            //Glide.with(mContext).load(Uri.fromFile(new File(path))).apply(options).into(holder.mPosterView);
            Glide.with(mContext).load(path).apply(options).into(holder.mPosterView);

        }

    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Anime_Model mItem;

        public final View mView;
        public final ImageView mPosterView;

        /* Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link AnimeAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            mPosterView = (ImageView) itemView.findViewById(R.id.image_list);
           // mTitle = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

<<<<<<< HEAD
=======
=======
public class BookMarksAdapter {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
}
