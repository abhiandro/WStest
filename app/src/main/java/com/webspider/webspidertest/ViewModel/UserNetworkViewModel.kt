package com.webspider.webspidertest.ViewModel

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.webspider.webspidertest.model.JsonResponse
import com.webspider.webspidertest.network.RestManager
import com.webspider.webspidertest.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserNetworkViewModel  : ViewModel(){



    fun  fetchValue():LiveData<JsonResponse>{
        return  UserRepository.getUSerData()
    }
}