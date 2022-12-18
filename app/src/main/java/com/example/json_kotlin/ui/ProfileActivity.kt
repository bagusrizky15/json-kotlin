package com.example.json_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.json_kotlin.databinding.ActivityProfileBinding
import com.example.json_kotlin.helper.PreferenceHelper

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    private lateinit var sharedPreferences: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = PreferenceHelper(this)
        binding.btnLogout.setOnClickListener{
            sharedPreferences.clear()
            Toast.makeText(applicationContext, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}