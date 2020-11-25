package com.webspider.webspidertest.model

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity  constructor(email : String, gender : String , first : String, last : String, title : String, street_number : String, street_name: String,
                                city : String , country : String , postcode : String, state : String, phone: String, cell : String, large : String,
                              medium: String, thumbnail: String){


    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @ColumnInfo(name = "email")
    var email : String? = email

    @ColumnInfo(name = "gender")
    var gender : String? = gender

    @ColumnInfo(name = "first")
    var first : String? = first

    @ColumnInfo(name = "last")
    var last : String? = last

    @ColumnInfo(name = "title")
    var title : String? = title


    //Address

    @ColumnInfo(name = "street_number")
    var street_number : String? = street_number


    @ColumnInfo(name = "street_name")
    var street_name : String? =street_name


    @ColumnInfo(name = "city")
    var city : String? = city

    @ColumnInfo(name = "country")
    var country : String? = country

    @ColumnInfo(name = "postcode")
    var postcode : String? = postcode

     @ColumnInfo(name = "state")
        var state : String? = state

    ///contact

    @ColumnInfo(name = "phone")
    var phone : String? = phone

     @ColumnInfo(name = "cell")
        var cell : String? = cell

    //picture

    @ColumnInfo(name = "large")
    var large : String? = large

    @ColumnInfo(name = "medium")
    var medium : String? = medium

    @ColumnInfo(name = "thumbnail")
    var thumbnail : String? = thumbnail


}