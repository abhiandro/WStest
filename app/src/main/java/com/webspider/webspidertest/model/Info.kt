package com.webspider.webspidertest.model

import com.google.gson.annotations.SerializedName

class Info {
    @SerializedName("page")
    var  page : Int ? = null

    @SerializedName("results")
    var results : String ? =null

    @SerializedName("seed")
    var seed : String ? = null

    @SerializedName("version")
    var  version : String ? = null

}