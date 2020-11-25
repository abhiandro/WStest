package com.webspider.webspidertest.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.repository.UsersOfflineRepository
import com.webspider.webspidertest.room.Dao.UsersDao
import java.util.*

class UsersPagingViewModel ():ViewModel() {

    fun getPaggingData(context: Context): LiveData<PagedList<UserEntity>>{
        return  UsersOfflineRepository.getDataFromLocal(context)
    }
}