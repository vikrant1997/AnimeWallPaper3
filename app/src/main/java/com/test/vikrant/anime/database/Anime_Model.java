package com.test.vikrant.anime.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

@Entity(tableName="task")
public class Anime_Model {
    @Ignore
    public Anime_Model(){

    }
    @NonNull
    @ColumnInfo(name = "ID")
    protected int mId;

    @ColumnInfo(name="URL")
    private String mAnimeUri;
    @NonNull@ColumnInfo(name="IMAGEID")@PrimaryKey
    private String mImageId;

    public Anime_Model(String mAnimeUri,String mImageId){
        this.mAnimeUri=mAnimeUri;
        this.mImageId=mImageId;
    }

    public String getImageId() {
        return mImageId;
    }

    public String getAnimeUri() {
        return mAnimeUri;
    }

    public String getmImageId(){return mImageId; }

}
