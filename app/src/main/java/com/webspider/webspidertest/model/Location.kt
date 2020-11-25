package com.webspider.webspidertest.model

import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("street")
    var street : street ? = null


    @SerializedName("city")
    var city : String ?= null

    @SerializedName("state")
    var state : String ?= null

    @SerializedName("country")
        var country : String ?= null


    @SerializedName("postcode")
            var postcode : String ?= null



}