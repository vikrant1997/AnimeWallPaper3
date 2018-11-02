package com.test.vikrant.anime.database;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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
<<<<<<< HEAD

    @ColumnInfo(name="IMAGE_FINAL")
    private String mAnimeFinal;

    @NonNull@ColumnInfo(name="IMAGEID")@PrimaryKey
    private String mImageId;

    public Anime_Model(String mAnimeUri,String mImageId,String mAnimeFinal){
        this.mAnimeUri=mAnimeUri;
        this.mImageId=mImageId;
        this.mAnimeFinal=mAnimeFinal;
=======
    @NonNull@ColumnInfo(name="IMAGEID")@PrimaryKey
    private String mImageId;

    public Anime_Model(String mAnimeUri,String mImageId){
        this.mAnimeUri=mAnimeUri;
        this.mImageId=mImageId;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    }

    public String getImageId() {
        return mImageId;
    }

    public String getAnimeUri() {
        return mAnimeUri;
    }

<<<<<<< HEAD

    public String getAnimeFinal() {
        return mAnimeFinal;
    }

    public void setmAnimeFinal(String mAnimeFinal) {
        this.mAnimeFinal = mAnimeFinal;
    }

    public void setmAnimeUri(String mAnimeUri) {
        this.mAnimeUri = mAnimeUri;
    }

    public void setmImageId(@NonNull String mImageId) {
        this.mImageId = mImageId;
    }
    // public String getmImageId(){return mImageId; }

=======
    public String getmImageId(){return mImageId; }

=======
public class Anime_Model {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
}
