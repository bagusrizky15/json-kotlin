package com.example.json_kotlin.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_kotlin.model.TopMovie

class MovieAdapter(val movies: ArrayList<TopMovie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    class MovieViewHolder {
        

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = movies.size


}