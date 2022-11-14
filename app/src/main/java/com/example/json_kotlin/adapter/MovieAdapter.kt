package com.example.json_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_kotlin.R
import com.example.json_kotlin.model.TopMovie

class MovieAdapter(val results: ArrayList<TopMovie.Result>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = results.size
    }

}