package com.example.roomdbinjava.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {UserDB.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context){
        //ha nincs még példány
        if(INSTANCE == null){
             INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "DB_NAME").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}