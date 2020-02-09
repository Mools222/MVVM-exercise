package com.mools.mvvm_exercise.c_mvvm_persistence.persistence.sqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TextDao {
    @Query("SELECT * FROM text ORDER BY id DESC LIMIT 1")
    Text getLastText();

    @Insert
    void insert(Text text);

    @Delete
    void delete(Text text);
}
