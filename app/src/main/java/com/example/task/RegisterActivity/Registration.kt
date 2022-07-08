package com.example.task.RegisterActivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task.LogInActivity.LogIn
import com.example.task.Pojo.Const
import com.example.task.Retrofit.RegisterUser.RegisterViewModel
import com.example.task.databinding.ActivityRegistrationBinding
import com.example.task.showToast


class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val map = HashMap<String, String?>()
    val registerViewmodel = RegisterViewModel()
    var ispressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()

    }

    fun onClick() {
        binding.registerButton.setOnClickListener {
            binding.apply {
                val email = emailReg.text.toString()
                val password = passwordReg.text.toString()
                val name = nameReg.text.toString()
                if (email.isBlank()) {
                    emailReg.error = "IsEmpty"
                    showToast(applicationContext, "Email is Empty  ")
                }
                if (name.isBlank()) {
                    nameReg.error = "IsEmpty"
                    showToast(applicationContext, "Name is Empty  ")
                }
                if (password.isBlank()) {
                    passwordReg.error = "IsEmpty"
                    showToast(applicationContext, "Password  is Empty  ")

                }
                if (email.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(binding.emailReg.text.toString())
                        .matches()
                ) {
                    showToast(applicationContext, "Email is Invalid  ")

                } else {
                    observer()
                }
            }

        }

    }

    fun observer() {
        binding.apply {
            map["email"] = emailReg.text.toString()
            map["name"] = nameReg.text.toString()
            map["password"] = passwordReg.text.toString()

            registerViewmodel.getResponseUser(map).observe(this@Registration) {
                if (it.token.isEmpty()) {
                    showToast(baseContext, "Failed")

                }
                var data = it.token
                val preferences: SharedPreferences =
                    applicationContext.getSharedPreferences("token", Context.MODE_PRIVATE)
                preferences.edit().putString(Const.TOKEN, data).apply()
                showToast(applicationContext, "Successfully ")
                startActivity(Intent(applicationContext, LogIn::class.java))
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
