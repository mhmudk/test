package com.example.task.Retrofit.RegisterUser

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.task.LogInActivity.LogIn
import com.example.task.Retrofit.Builder.BuilderApiClient
import com.example.task.Retrofit.LoginApi.LogInRequest
import com.example.task.Retrofit.LoginApi.RepoLoginUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRegister {

    fun register(map: HashMap<String, String?>): MutableLiveData<ModelRegisterResponseRemote> {
        var mutable = MutableLiveData<ModelRegisterResponseRemote>()
        var registerResponseCall: Call<ModelRegisterResponseRemote> =
            BuilderApiClient().getService().RegisterUser(map)
        registerResponseCall.enqueue(object : Callback<ModelRegisterResponseRemote> {
            override fun onFailure(call: Call<ModelRegisterResponseRemote>?, t: Throwable?) {

            }
            override fun onResponse(call: Call<ModelRegisterResponseRemote>?, response: Response<ModelRegisterResponseRemote>?) {
                if (response != null) {
                    mutable.postValue(response.body())
                }
            }
        })
            return mutable
    }
    }



