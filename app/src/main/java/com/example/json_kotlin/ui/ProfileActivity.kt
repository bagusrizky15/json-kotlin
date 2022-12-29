package com.example.json_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.json_kotlin.databinding.ActivityProfileBinding
import com.example.json_kotlin.helper.Constant
import com.example.json_kotlin.helper.PreferenceHelper
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener{
            Firebase.auth.signOut()
            Toast.makeText(applicationContext, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
            moveIntent()
        }

        binding.btnUpdate.setOnClickListener {
            Toast.makeText(this, "Berhasil Update", Toast.LENGTH_SHORT).show()
            updateIntent()
        }
    }

    private fun updateIntent() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

    private fun moveIntent() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}