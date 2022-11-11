package com.example.json_kotlin.model

data class ResponseModel (
    val status: Boolean,
    val data: ArrayList<Movies>,
    ){
    data class Movies(
        val id: Int,
        var title: String?,
        var overview: String?
    )
}
