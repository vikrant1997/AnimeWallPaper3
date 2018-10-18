package com.test.vikrant.anime.database;
<<<<<<< HEAD
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.Nullable;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    LiveData<List<Anime_Model>> loadAllTasks();


//    @Query("SELECT star FROM task where ID=:mId")
//    String loadStarValue(int mId);
    @Nullable
    @Query(("SELECT URL FROM task where IMAGEID=:imageId"))
    String checkHeart(String imageId);

//    @Query("SELECT URL FROM task where ID=:manimeId")
//    String getPath(int manimeId);

    @Query("DELETE FROM task where IMAGEID=:imageId")
    void delteById(String imageId);

    @Insert
    void insertTask(Anime_Model taskEntry);
//
//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    void updateTask(Anime_Model taskEntry);
//
//    @Delete
//    void deleteTask(Anime_Model taskEntry);



=======

public interface TaskDao {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
}
