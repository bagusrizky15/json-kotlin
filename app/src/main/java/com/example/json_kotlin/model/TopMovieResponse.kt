package com.example.json_kotlin.model

data class TopMovieResponse(
    var page: Int?,
    var results: ArrayList<TopMovie?>?,
    var total_pages: Int?,
    var total_results: Int?
)