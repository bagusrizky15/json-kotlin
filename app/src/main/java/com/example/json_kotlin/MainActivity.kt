package com.example.json_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.json_kotlin.api.ApiClient
import com.example.json_kotlin.api.ApiKey
import com.example.json_kotlin.model.TopMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchAllData()
    }

    private fun fetchAllData() {
        ApiClient.apiClient.getMoviesTopRated(ApiKey.apiKeyMovieDB)
            .enqueue(object : Callback<TopMovieResponse>{
                override fun onResponse(call: Call<TopMovieResponse>, response: Response<TopMovieResponse>) {

                    //val listMovie = movie?.results
//                    Log.d("COBAIN", response.toString())
//                    Log.e("COBAIN", Gson().toJson(listMovie?.get(0)))
                }

                override fun onFailure(call: Call<TopMovieResponse>, t: Throwable) {
                   // Log.d("YACOBA", t.message.toString())
                }
            })
    }

}