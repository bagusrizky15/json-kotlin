package com.example.json_kotlin

data class TopMovie(
    var page: Int?,
    var results: List<Result?>?,
    var total_pages: Int?,
    var total_results: Int?
)