package com.test.vikrant.anime.ViewHolder;

<<<<<<< HEAD
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.vikrant.anime.Interface.ItemClickListener;
import com.test.vikrant.anime.R;

public class BottomCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView category_name;
    ItemClickListener itemClickListener;
    public TextView category_id;
    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public BottomCategoryViewHolder(View itemView){
        super(itemView);
        //background_image=itemView.findViewById(R.id.bottom_category_image);
        category_name=itemView.findViewById(R.id.bottom_category_name);
        category_id=itemView.findViewById(R.id.bottom_category_id);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onclick(v,getAdapterPosition());
    }
}
=======
public class BottomCategoryViewHolder {
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
