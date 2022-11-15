package com.example.json_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_kotlin.adapter.MovieAdapter
import com.example.json_kotlin.api.ApiClient
import com.example.json_kotlin.api.ApiKey
import com.example.json_kotlin.databinding.ActivityMainBinding
import com.example.json_kotlin.model.TopMovie
import com.example.json_kotlin.model.TopMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MovieAdapter(arrayListOf(), this@MainActivity)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
        fetchAllData()
    }

    private fun fetchAllData() {
        ApiClient.apiClient.getMoviesTopRated(ApiKey.apiKeyMovieDB)
            .enqueue(object : Callback<TopMovieResponse>{
                override fun onResponse(call: Call<TopMovieResponse>, response: Response<TopMovieResponse>) {
                    val movie = response.body()
                    val listMovie = movie?.results
                    setData(listMovie)
//                    Log.d("COBAIN", response.toString())
//                    Log.e("COBAIN", Gson().toJson(listMovie?.get(0)))
                }

                override fun onFailure(call: Call<TopMovieResponse>, t: Throwable) {
                   // Log.d("YACOBA", t.message.toString())
                }
            })
    }

    private fun setData(result: ArrayList<TopMovie?>?) {
        adapter.setData(result)
    }

}