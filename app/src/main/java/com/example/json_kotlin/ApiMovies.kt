package com.example.json_kotlin

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

class ApiMovies {
    interface Movies {
        @GET("/movie/top_rated")
        fun getMoviesTopRated(@Query("api_key")apiKey: String)

        @POST



    }
}