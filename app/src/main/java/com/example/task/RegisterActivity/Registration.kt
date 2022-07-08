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
import com.example.task.Retrofit.RegisterUser.RegisterViewModel
import com.example.task.databinding.ActivityRegistrationBinding


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
            if (TextUtils.isEmpty(binding.emailReg.text.toString()) && !Patterns.EMAIL_ADDRESS.matcher(binding.emailReg.text.toString()).matches()) {
                Toast.makeText(applicationContext, "Email is Invalid  ", Toast.LENGTH_LONG).show()
            }else if (TextUtils.isEmpty(binding.nameReg.text)) {
                Toast.makeText(applicationContext, "Name is Empty  ", Toast.LENGTH_LONG).show()
            } else if (TextUtils.isEmpty(binding.passwordReg.text)){
                Toast.makeText(applicationContext, "Password  is Empty  ", Toast.LENGTH_LONG).show()
                }
             else {
                map["email"] = binding.emailReg.text.toString()
                map["name"] = binding.nameReg.text.toString()
                map["password"] = binding.passwordReg.text.toString()

                registerViewmodel.getResponseUser(map).observe(this) {
                    if (it.token.isEmpty()) {
                        Toast.makeText(applicationContext, "Failed  ", Toast.LENGTH_LONG).show()

                    }
                    var data = it.token
                    val preferences: SharedPreferences =
                        applicationContext.getSharedPreferences("token", Context.MODE_PRIVATE)
                    preferences.edit().putString("TOKEN", data).apply()
                    Toast.makeText(applicationContext, "Successfully ", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, LogIn::class.java))
                }
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
