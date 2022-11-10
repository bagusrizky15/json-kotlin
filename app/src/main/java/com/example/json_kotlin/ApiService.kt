package com.example.json_kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Movies {
        @GET("/movie/top_rated")
        fun getMoviesTopRated(@Query("api_key")apiKey: String) : Call<TopMovie>
    }