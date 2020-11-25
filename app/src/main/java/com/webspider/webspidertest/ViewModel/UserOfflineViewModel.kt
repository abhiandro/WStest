package com.webspider.webspidertest.ViewModel

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.repository.UsersOfflineRepository

class UserOfflineViewModel : ViewModel() {

    var userList: LiveData<UserEntity>? = null

    fun insertValue(context: Context,userEntity: ArrayList<UserEntity>): MutableLiveData<String>{
       return UsersOfflineRepository.InsertValueDb(context,userEntity)
    }

    fun getAllValue(context: Context){
        UsersOfflineRepository.getAllByLimit(context)
    }

    fun deleteAll(context: Context) : MutableLiveData<String>
    {
        var re = UsersOfflineRepository.deleteAll(context)

        return  re
    }

    fun getValueByEmail(context: Context,email: String): LiveData<List<UserEntity>>{

       return UsersOfflineRepository.getValue_byEmail(context, email)

    }

}