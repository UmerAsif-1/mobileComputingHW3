package com.example.hw3mc.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import android.net.Uri
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT COUNT(*) FROM User")
    fun isEmpty(): Int
    @Insert
    fun insertInitialItem(item: User)

    @Query("SELECT * FROM User")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE id= :id")
    fun getInfo(id: Long): LiveData<List<User>>



}