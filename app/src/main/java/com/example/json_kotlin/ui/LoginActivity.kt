package com.example.json_kotlin.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.json_kotlin.MainActivity
import com.example.json_kotlin.databinding.ActivityLoginBinding
import com.example.json_kotlin.helper.Constant
import com.example.json_kotlin.helper.PreferenceHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences : PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        binding.btnDaftar.setOnClickListener{
            val j = Intent(this, RegisterActivity::class.java)
            startActivity(j)
        }

        sharedPreferences = PreferenceHelper(this)

        binding.btnLogin.setOnClickListener{
            sharedPreferences.put(Constant.PREF_EMAIL, binding.tvEmail.text.toString())
            sharedPreferences.put(Constant.PREF_PASSWORD, binding.tvPassword.text.toString())
            sharedPreferences.put(Constant.PREF_IS_LOGIN, true)
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
            moveIntent()
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser!= null){
            reload()
        }
        if (sharedPreferences.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun reload() {
        TODO("Not yet implemented")
    }

    private fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}