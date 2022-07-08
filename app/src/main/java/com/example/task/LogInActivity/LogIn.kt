package com.example.task.LogInActivity

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task.MainActivity
import com.example.task.Retrofit.Builder.BuilderApiClient
import com.example.task.Retrofit.LoginApi.LogInRequest
import com.example.task.Retrofit.LoginApi.LoginViewModel
import com.example.task.databinding.ActivityLogInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private val map = HashMap<String, String?>()
    var loginViewModel = LoginViewModel()
    var pressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.emailLogin.text.toString()) || TextUtils.isEmpty(binding.passwordLogin.text.toString())) {
                Toast.makeText(applicationContext, "Please Fields required", Toast.LENGTH_LONG)
                    .show()

            } else {
                map["email"] = binding.emailLogin.text.toString()
                map["password"] = binding.passwordLogin.text.toString()
                loginViewModel.getResponseUser(map).observe(this) {
                    val preferences: SharedPreferences =
                        applicationContext.getSharedPreferences("token", Context.MODE_PRIVATE)
                    preferences.edit().putString("TOKEN", it.token).apply()
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))

                }
            }

        }
    }

    /*

     */
    fun logInRequestUser(loginrequest: HashMap<String, String?>) {
        val loginrequestCall: Call<LogInRequest> =
            BuilderApiClient().getService().logInUser(loginrequest)
        loginrequestCall.enqueue(object : Callback<LogInRequest> {

            override fun onResponse(
                call: Call<LogInRequest>?,
                response: Response<LogInRequest>?
            ) {
                if (response != null) {
                    var data = response.body()

                    val preferences: SharedPreferences =
                        this@LogIn.getSharedPreferences("token", Context.MODE_PRIVATE)
                    preferences.edit().putString("TOKEN", data?.token).apply()



                    Toast.makeText(applicationContext, "Successfully", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@LogIn, MainActivity::class.java))
                }
            }

            override fun onFailure(call: Call<LogInRequest>?, t: Throwable?) {
                Log.d("Error", t.toString())
            }


        })

    }

    override fun onBackPressed() {
        if(pressed){
            super.onBackPressed();
        }
        else{
            return;
        }
    }
}