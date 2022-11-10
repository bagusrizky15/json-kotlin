package com.example.json_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playing()
        loadImage()
        fetchAllData()
    }

    private fun fetchAllData() {
        ApiClient.apiClient.getMoviesTopRated(ApiKey.apiKeyMovieDB)
            .enqueue(object : Callback<TopMovie>{
                override fun onResponse(call: Call<TopMovie>, response: Response<TopMovie>) {
                    val movie = response.body()
                    val listMovie = movie?.results
                    Log.d("COBAIN", response.toString())
                    Log.e("COBAIN", Gson().toJson(listMovie?.get(0)))
                }

                override fun onFailure(call: Call<TopMovie>, t: Throwable) {
                    Log.d("YACOBA", t.message.toString())
                }
            })
    }

    private fun loadImage(){
        Glide.with(this)
            .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
            .into(findViewById(R.id.imgView))
    }

    private fun playing() {
        val jsonObject = JSONObject()
        jsonObject.put("name", "Bagus")

        Log.e("cekJSON", jsonObject.getString("name"))
    }
}