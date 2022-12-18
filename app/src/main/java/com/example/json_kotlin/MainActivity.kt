package com.example.json_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_kotlin.adapter.MovieAdapter
import com.example.json_kotlin.api.ApiClient
import com.example.json_kotlin.api.ApiKey
import com.example.json_kotlin.databinding.ActivityMainBinding
import com.example.json_kotlin.helper.Constant
import com.example.json_kotlin.helper.PreferenceHelper
import com.example.json_kotlin.model.TopMovie
import com.example.json_kotlin.model.TopMovieResponse
import com.example.json_kotlin.ui.ProfileActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    lateinit var sharedPreferences : PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val welcome = "Welcome, "
        sharedPreferences = PreferenceHelper(this)
        binding.tvUsername.text = welcome + sharedPreferences.getString(Constant.PREF_EMAIL)

        binding.btnUser.setOnClickListener{
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }

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
                    adapter = listMovie?.let { MovieAdapter(it, this@MainActivity) }!!
                    binding.recycleView.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.recycleView.adapter = adapter
                    //setData(listMovie)
                    Log.d("COBAIN", response.toString())
                    Log.e("COBAIN", Gson().toJson(listMovie))
                }

                override fun onFailure(call: Call<TopMovieResponse>, t: Throwable) {
                    Log.d("YACOBA", t.message.toString())
                    Log.d("Error Get", ""+t.stackTraceToString())
                }
            })
    }

    private fun setData(result: ArrayList<TopMovie>?) {
        adapter.setData(result)
        adapter.notifyDataSetChanged()
    }

}