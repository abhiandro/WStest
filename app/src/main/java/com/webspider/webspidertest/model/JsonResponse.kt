package com.webspider.webspidertest.model

import com.google.gson.annotations.SerializedName

class  JsonResponse{

    @SerializedName("results")
    var results : ArrayList<UserDetails> ? = null

    @SerializedName("info")
    var info : Info ? = null


}