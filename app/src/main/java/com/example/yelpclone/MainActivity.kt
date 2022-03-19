package com.example.yelpclone


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY ="O8hkIqLVDJLd9njMy0l-VduP0LTPLmcLQLGDpe_Mwaxe8zmiWERyOaJ_9tIFepMB46QuHe80Ey2dGo-LrC4pgT6M3aJrg6vFJtf13DqYpOddvpz1pFDHN0h9qXk1YnYx"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val yelpService = retrofit.create(YelpService::class.java)

        yelpService.searchRestaurant("Bearer $API_KEY","Starbucks","NYC").enqueue(object : Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.i("Main","respons: ${response}")
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("Main","error: ${t}")
            }

        })


    }
}