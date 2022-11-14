package com.example.json_kotlin.model

data class TopMovie(
    var page: Int?,
    var results: ArrayList<Result?>?,
    var total_pages: Int?,
    var total_results: Int?
){
    data class Result (
        var id: Int?,
        var title: String?,
        var overview: String?
        )
}