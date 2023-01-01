package com.example.json_kotlin.repository

import com.example.json_kotlin.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getData() = apiHelper.getMoviesData()
}