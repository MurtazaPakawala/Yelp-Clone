package com.example.yelpclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface YelpService {

    @GET("businesses/search")
    fun searchRestaurant(
        @Header("Authorization") authHeader: String,
        @Query("term") SearchTerm:String,
        @Query("location") Location:String): Call<yelpSearch>


}