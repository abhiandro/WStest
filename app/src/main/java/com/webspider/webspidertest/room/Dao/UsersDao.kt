package com.webspider.webspidertest.room.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webspider.webspidertest.model.UserEntity


@Dao
interface UsersDao {

    @Insert
       fun InserteData(userEntity: UserEntity)


    @Query("SELECT * FROM users")
      fun getValue():LiveData<List<UserEntity>>


    @Query("SELECT * FROM users WHERE email=:email")
        fun  getValueByemail(email:String): LiveData<List<UserEntity>>

    @Query("DELETE FROM users")
        fun deleteAll()

    @Query("SELECT * FROM users")
        fun getAllValue(): DataSource.Factory<Int, UserEntity>

}