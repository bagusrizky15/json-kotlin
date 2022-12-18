package com.example.json_kotlin.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefName = "sharedPrefLogin"
    val editor : SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String) : Boolean{
        return sharedPreferences.getBoolean(key, false)
    }

    fun clear(){
        editor.clear()
            .apply()
    }
}