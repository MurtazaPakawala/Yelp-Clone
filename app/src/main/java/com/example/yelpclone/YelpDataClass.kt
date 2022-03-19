package com.example.yelpclone

import com.google.gson.annotations.SerializedName

data class yelpSearch(
    @SerializedName("businesses") val Restaurant : List<YelpRes>
)

data class YelpRes (
    val name : String,
    val rating : Double,
    val price : String,
    val image_url : String

        )
