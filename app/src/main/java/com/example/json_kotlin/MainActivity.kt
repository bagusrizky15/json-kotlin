package com.example.json_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playing()
    }

    private fun playing() {
        val jsonObject = JSONObject()
        jsonObject.put("name", "Bagus")

        Log.e("cekJSON", jsonObject.getString("name"))
    }
}