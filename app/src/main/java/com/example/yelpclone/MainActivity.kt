package com.example.yelpclone


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
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

        //dragging the recycler view
        //making the layout
        rvRestaurant.layoutManager =LinearLayoutManager(this)
        //also need the data to present
        val data = mutableListOf<YelpRes>()
        //then setting up the adapter
        val adapter = YelpAdapter(this,data)
        rvRestaurant.adapter=adapter

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val yelpService = retrofit.create(YelpService::class.java)

        yelpService.searchRestaurant("Bearer $API_KEY","Pizza","Sydney").enqueue(object : Callback<yelpSearch>{
            override fun onResponse(call: Call<yelpSearch>, response: Response<yelpSearch>) {
                Log.i("Main","respons: ${response}")

                val body = response.body()
                if(body==null)
                {
                    Log.w("Main","did not get a valid response something is wrong please check again")
                    return
                }
                data.addAll(body.Restaurant)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<yelpSearch>, t: Throwable) {
                Log.i("Main","error: ${t}")
            }

        })


    }
}