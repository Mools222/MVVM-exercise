package com.mools.mvvm_exercise.c_mvvm_persistence.persistence.sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Text.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}
