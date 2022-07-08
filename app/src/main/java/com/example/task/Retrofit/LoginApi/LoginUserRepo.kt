package com.example.task.Retrofit.LoginApi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.task.LogInActivity.LogIn
import com.example.task.Retrofit.Builder.BuilderApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginUserRepo {
    fun logInRequestUser(loginrequest: HashMap<String, String?>): MutableLiveData<LogInRequest> {
        var mutable = MutableLiveData<LogInRequest>()
        val loginrequestCall: Call<LogInRequest> =
            BuilderApiClient().getService().logInUser(loginrequest)
        loginrequestCall.enqueue(object : Callback<LogInRequest> {
            override fun onResponse(call: Call<LogInRequest>?, response: Response<LogInRequest>?) {
                if (response != null) {
                    mutable.postValue(response.body())

                }
            }

            override fun onFailure(call: Call<LogInRequest>?, t: Throwable?) {
                Log.d("Error", t?.message.toString())

            }

        })
        return mutable
    }
}