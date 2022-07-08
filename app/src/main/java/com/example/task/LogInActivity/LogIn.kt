package com.example.task.LogInActivity

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task.MainActivity
import com.example.task.Pojo.Const
import com.example.task.Retrofit.Builder.BuilderApiClient
import com.example.task.Retrofit.LoginApi.LogInRequest
import com.example.task.Retrofit.LoginApi.LoginViewModel
import com.example.task.databinding.ActivityLogInBinding
import com.example.task.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private val map = HashMap<String, String?>()
    val loginViewModel = LoginViewModel()
    var ispressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    fun onClick() {
        binding.loginButton.setOnClickListener {
            binding.apply {
                val email = emailLogin.text.toString()
                val password = passwordLogin.text.toString()

                if (email.isBlank()) {
                    emailLogin.error = "IsEmpty"
                    showToast(applicationContext, "Email is Empty  ")
                }

                if (password.isBlank()) {
                    passwordLogin.error = "IsEmpty"
                    showToast(applicationContext, "Password  is Empty  ")
                }
                if (email.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(binding.emailLogin.text.toString())
                        .matches()
                ) {
                    showToast(applicationContext, "Email is Invalid  ")

                }
                else {
                    observer()
                }
            }

        }

    }

    fun observer() {
        binding.apply {
            map["email"] = emailLogin.text.toString()
            map["password"] = passwordLogin.text.toString()
            loginViewModel.getResponseUser(map).observe(this@LogIn) {
                val preferences: SharedPreferences =
                    applicationContext.getSharedPreferences("token", Context.MODE_PRIVATE)
                preferences.edit().putString(Const.TOKEN, it.token).apply()
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }


        }
    }

    override fun onBackPressed() {
        if (ispressed) {
            super.onBackPressed();
        } else {
            return;
        }
    }
}