package com.example.roomdbinjava.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM UserDB")
    List<UserDB> getAllUsers();

    @Insert
    void insertUserDB(UserDB userDB);

    @Update
    void updateUserDB(UserDB userDB);

    @Delete
    void deleteUserDB(UserDB userDB);
}
