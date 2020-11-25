package com.webspider.webspidertest.model

import com.google.gson.annotations.SerializedName

class Name {
    @SerializedName("first")
    var first : String ? = null

    @SerializedName("last")
    var  last : String ? = null

    @SerializedName("title")
    var title : String ?= null

}