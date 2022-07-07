package com.example.task.LogIn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.task.LoginRetrofit.ApiClient
import com.example.task.LoginRetrofit.LogInRequest.LogInRequest
import com.example.task.LoginRetrofit.LogInRequest.LogInResponse
import com.example.task.LoginRetrofit.ReqisterRequest.RegisterResponse
import com.example.task.LoginRetrofit.ReqisterRequest.ReqisterRequest
import com.example.task.R
import com.example.task.databinding.ActivityLogInBinding
import com.example.task.databinding.ActivityRegistrationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.emailLogin.text.toString()) || TextUtils.isEmpty(binding.passwordLogin.text.toString())) {
                Toast.makeText(applicationContext, "Please Fields required", Toast.LENGTH_LONG)
                    .show()

            } else {
                var loginRequest: LogInRequest = LogInRequest(
                    binding.emailLogin.text.toString(),
                    binding.passwordLogin.text.toString(),
                )
logInRequestUser(loginRequest)
            }

        }
    }
fun logInRequestUser(loginrequest:LogInRequest){
    var  loginrequestCall: Call<LogInResponse> = ApiClient().getService().logInUser(loginrequest)
    loginrequestCall.enqueue(object : Callback<LogInResponse> {
        override fun onFailure(call: Call<LogInResponse>?, t: Throwable?) {
            Log.d("Error",t.toString())
        }

        override fun onResponse(call: Call<LogInResponse>?, response: Response<LogInResponse>?) {
            Toast.makeText(applicationContext,  "Successfully",Toast.LENGTH_LONG).show()
        }

    })

}
}