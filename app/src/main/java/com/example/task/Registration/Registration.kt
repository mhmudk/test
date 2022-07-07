package com.example.task.Registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.task.LoginRetrofit.ApiClient

import com.example.task.LoginRetrofit.ReqisterRequest.RegisterResponse
import com.example.task.LoginRetrofit.ReqisterRequest.ReqisterRequest
import com.example.task.R
import com.example.task.databinding.ActivityRegistrationBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
binding.registerButton.setOnClickListener {
    if(TextUtils.isEmpty( binding.emailReg.text.toString())|| TextUtils.isEmpty(binding.nameReg.text.toString())||TextUtils.isEmpty(binding.phoneReg.text.toString())|| TextUtils.isEmpty(binding.passwordReg.text.toString())) {
        Toast.makeText(applicationContext,"Please Fields required",Toast.LENGTH_LONG).show()

    }else {
        var registerRequest :ReqisterRequest = ReqisterRequest(
            binding.emailReg.text.toString(),
            binding.nameReg.text.toString(),
            binding.phoneReg.text.toString(),
            binding.passwordReg.text.toString(),

            )
        register(registerRequest)
    }


}
    }
    fun register(registerquest: ReqisterRequest){
var  registerResponseCall: Call<RegisterResponse> =ApiClient().getService().RegisterUser(registerquest)
        registerResponseCall.enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>?, t: Throwable?) {
Log.d("Error",t.toString())
            }

            override fun onResponse(call: Call<RegisterResponse>?, response: Response<RegisterResponse>?) {
Toast.makeText(applicationContext,  "Successfully",Toast.LENGTH_LONG).show()
            }

        })


    }
    }
