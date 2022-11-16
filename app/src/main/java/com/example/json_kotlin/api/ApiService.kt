package com.example.json_kotlin.api

import com.example.json_kotlin.model.TopMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("movie/top_rated")
        fun getMoviesTopRated(@Query("api_key")apiKey: String) : Call<TopMovieResponse>
    }