package com.mools.mvvm_exercise.c_mvvm_persistence.persistence.sqlite;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Text {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "text_message")
    public String textMessage;
}