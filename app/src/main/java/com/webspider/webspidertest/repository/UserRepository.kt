package com.webspider.webspidertest.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.webspider.webspidertest.ViewModel.UserOfflineViewModel
import com.webspider.webspidertest.model.JsonResponse
import com.webspider.webspidertest.network.RestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserRepository {

    companion object{
        var muteableLiveData : MutableLiveData<JsonResponse> = MutableLiveData()

        fun  getUSerData(): MutableLiveData<JsonResponse> {

            var apiTest : Call<JsonResponse> = RestManager.getInstance().service.JSON_RESPONSE_CALL(500)

            apiTest.enqueue(object : Callback<JsonResponse> {
                override fun onResponse(call: Call<JsonResponse>, response: Response<JsonResponse>) {
                    if(response.code()==200){

                        try {
                            var  jsonResponse: JsonResponse? = response.body()
                            var info = jsonResponse!!.info
                            Log.e("Result",""+info!!.results)
                            muteableLiveData.postValue(jsonResponse)



                        }catch (ex : Exception){
                            Log.e("Fetch EX",""+ex.message)
                        }

                    }

                }
                override fun onFailure(call: Call<JsonResponse>, t: Throwable) {
                    muteableLiveData.postValue(null)
                }
            })
            Log.e("Mute",""+ muteableLiveData.toString())
            return  muteableLiveData
        }
    }

}