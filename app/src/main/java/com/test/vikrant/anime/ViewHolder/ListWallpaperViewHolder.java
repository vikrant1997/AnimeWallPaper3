package com.test.vikrant.anime.ViewHolder;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.R;

public class ListWallpaperViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemClickListener itemClickListener;
    public ImageView wallpaper;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ListWallpaperViewHolder(View itemView) {
        super(itemView);
        wallpaper=(ImageView) itemView.findViewById(R.id.image_list);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    itemClickListener.onclick(v,getAdapterPosition());
    }

<<<<<<< HEAD
=======
=======
public class ListWallpaperViewHolder {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
}
