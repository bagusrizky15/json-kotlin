package com.example.json_kotlin.api

class ApiHelper (private val apiService: ApiService) {

    suspend fun getMoviesData() = apiService.getMoviesTopRated()
}