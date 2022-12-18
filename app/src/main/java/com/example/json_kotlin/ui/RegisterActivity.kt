package com.example.json_kotlin.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.json_kotlin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefName = "sharefPrefBagus"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
        binding.btnRegister.setOnClickListener{
            val username = binding.tvUsername.text.toString()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("username_key", username)
            editor.putString("email_key", email)
            editor.putString("password_key", password)
            editor.apply()
            Toast.makeText(this, "Data Tersimpan", Toast.LENGTH_SHORT).show()
        }
    }
}