package com.example.json_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playing()
        loadImage()
    }

    private fun loadImage(){
        Glide.with(this)
            .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
            .into(findViewById(R.id.imgView))
    }

    private fun playing() {
        val jsonObject = JSONObject()
        jsonObject.put("name", "Bagus")

        Log.e("cekJSON", jsonObject.getString("name"))
    }
}