package com.example.json_kotlin

import retrofit2.http.*

class ApiMovies {
    interface Movies {
        @GET("/movie/top_rated")
        fun getMoviesTopRated(@Query("api_key")apiKey: String)

        @POST("/movie/{movie_id}/rating")
        fun postRate(@Path("movie_id") movie_id: String)

        @DELETE
        fun funt()
    }
}