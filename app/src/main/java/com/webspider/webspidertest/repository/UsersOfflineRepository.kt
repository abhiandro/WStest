package com.webspider.webspidertest.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.room.AppDatabase
import com.webspider.webspidertest.room.Dao.UsersDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersOfflineRepository {



    companion object{

        var  appDatabase : AppDatabase ?= null

        var userList: LiveData<List<UserEntity>> ? = null


        fun InitDB(context: Context):AppDatabase{
            return  AppDatabase.getInstance(context)
        }

        fun InsertValueDb(context: Context,userEntity: ArrayList<UserEntity>) : MutableLiveData<String>{

            appDatabase = InitDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                for (i in userEntity)
                appDatabase!!.UserDao().InserteData(i)
            }
            var  mutableLiveData : MutableLiveData<String> = MutableLiveData("1");

            return mutableLiveData
        }

        fun getAllByLimit(context: Context): LiveData<List<UserEntity>>{
            appDatabase = InitDB(context)

            userList = appDatabase!!.UserDao().getValue();

            return userList as LiveData<List<UserEntity>>;
        }


        fun deleteAll(context: Context) : MutableLiveData<String>{

            appDatabase = InitDB(context);
            CoroutineScope(Dispatchers.IO).launch {
                appDatabase!!.UserDao().deleteAll()
            }
            var data : MutableLiveData<String> = MutableLiveData("1")
            return data
        }


        fun getDataFromLocal(context: Context) : LiveData<PagedList<UserEntity>>{
            appDatabase = InitDB(context);
            val userslist :LiveData<PagedList<UserEntity>> = LivePagedListBuilder(appDatabase!!.UserDao().getAllValue(),pagedListConfig()).build()
            return userslist
        }


        fun getValue_byEmail(context: Context, email : String):LiveData<List<UserEntity>>{
            appDatabase = InitDB(context)

            var data = appDatabase!!.UserDao().getValueByemail(email)

            return  data
        }

        fun pagedListConfig() = PagedList.Config.Builder()
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .setEnablePlaceholders(true)
            .build()

    }

}