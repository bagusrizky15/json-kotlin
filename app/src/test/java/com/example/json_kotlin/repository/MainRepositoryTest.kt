package com.example.json_kotlin.repository

import com.example.json_kotlin.api.ApiHelper
import com.example.json_kotlin.api.ApiService
import com.example.json_kotlin.model.TopMovieResponse
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test
import org.mockito.kotlin.mock

class MainRepositoryTest {
    private lateinit var apiHelper: ApiHelper
    private lateinit var apiService: ApiService
    private lateinit var repository: MainRepository

    @Before
    fun setup() {
        apiService = mockk()
        apiHelper = ApiHelper(apiService)
    }

    @Test
    fun getData() {
        val responseAlldata = mock<TopMovieResponse>()
        every {
            runBlocking {
                apiService.getMoviesTopRated()
            }
            return@every responseAlldata
        }
    }
}