package com.example.json_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.json_kotlin.MainActivity
import com.example.json_kotlin.R
import com.example.json_kotlin.adapter.MovieAdapter
import com.example.json_kotlin.databinding.ActivityDetailBinding
import com.example.json_kotlin.databinding.ActivityMainBinding
import com.example.json_kotlin.model.TopMovie
import com.example.json_kotlin.model.TopMovieResponse

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}