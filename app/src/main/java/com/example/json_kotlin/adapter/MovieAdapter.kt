package com.example.json_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_kotlin.R
import com.example.json_kotlin.databinding.ItemMoviesBinding
import com.example.json_kotlin.model.TopMovie

class MovieAdapter(val result: ArrayList<TopMovie>, val context: Context
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemMoviesBinding.bind(view)
        val tvTitle = binding.tvTitle
        val tvDesc = binding.tvDesc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = result[position].title
        holder.tvDesc.text = result[position].overview
    }

    override fun getItemCount() = result.size

    fun setData(result: ArrayList<TopMovie?>?){
        result?.clear()
        result?.addAll(result)
        notifyDataSetChanged()
    }




}