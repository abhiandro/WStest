package com.webspider.webspidertest.model

import com.google.gson.annotations.SerializedName

class UserDetails {


    @SerializedName("gender")
    var gender : String ? = null

    @SerializedName ("name")
    var name : Name ? = null


    @SerializedName("location")
    var location : Location ? = null


    @SerializedName("email")
    var email : String ? = null

    @SerializedName("login")
    var login : LogIn ? = null

     @SerializedName("phone")
     var phone : String ? = null

    @SerializedName("cell")
     var cell : String ? = null


    @SerializedName("picture")
    var picture : Picture ? = null

}