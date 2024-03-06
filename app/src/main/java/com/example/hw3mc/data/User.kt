package com.example.hw3mc.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.net.Uri


@Entity
data class User(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    var photoUri: String,
    var username: String
){

}