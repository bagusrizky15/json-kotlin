package com.example.json_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.json_kotlin.databinding.ActivityProfileBinding
import com.example.json_kotlin.helper.Constant
import com.example.json_kotlin.helper.PreferenceHelper

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var sharedPreferences: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = PreferenceHelper(this)
        binding.tvEmail.hint = sharedPreferences.getString(Constant.PREF_EMAIL)
        binding.tvUsername.hint = sharedPreferences.getString(Constant.PREF_EMAIL)
        binding.tvPassword.hint = sharedPreferences.getString(Constant.PREF_PASSWORD)
        binding.btnLogout.setOnClickListener{
            sharedPreferences.clear()
            Toast.makeText(applicationContext, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
            moveIntent()
        }

        binding.btnUpdate.setOnClickListener {
            sharedPreferences.put(Constant.PREF_EMAIL, binding.tvEmail.text.toString())
            sharedPreferences.put(Constant.PREF_PASSWORD, binding.tvPassword.text.toString())
            sharedPreferences.put(Constant.PREF_IS_LOGIN, true)
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