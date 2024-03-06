package com.example.hw3mc.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository: UserRepository
    private val readAll : LiveData<List<User>>
    init {
        val profileInfoDB = UserDatabase.getInstance(application).dao()
        repository = UserRepository(profileInfoDB)
        readAll = repository.getAll()



    }
    fun isEmpty(): Boolean{

        return repository.isEmpty()

    }
    fun addInfo(info: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.insertUser(info)
        }
    }
    fun getInfo(id: Long): LiveData<List<User>>{

        return repository.getInfo(id)

    }
    fun getAll(): LiveData<List<User>>{
        return repository.getAll()
    }




}