package com.example.hw3mc.data

import androidx.lifecycle.LiveData
import com.example.hw3mc.data.User
import com.example.hw3mc.data.UserDao



class UserRepository(
    private val dao: UserDao
) {
    suspend fun insertUser(user: User){
        dao.insertUser(user)
    }
    fun isEmpty(): Boolean {
        return dao.isEmpty() == 0
    }
    fun insertInitialItem(item: User){
        dao.insertInitialItem(item)
    }

    fun getAll(): LiveData<List<User>> = dao.getAll()


    fun getInfo(id: Long): LiveData<List<User>> = dao.getInfo(id)

}