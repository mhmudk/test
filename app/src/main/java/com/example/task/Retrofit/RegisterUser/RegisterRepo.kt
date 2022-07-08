package com.example.task.Retrofit.RegisterUser

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.task.Retrofit.Builder.BuilderApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepo {

    fun register(map: HashMap<String, String?>): MutableLiveData<ModelRegisterResponseRemote> {
        var mutable = MutableLiveData<ModelRegisterResponseRemote>()
        var registerResponseCall: Call<ModelRegisterResponseRemote> =
            BuilderApiClient().getService().RegisterUser(map)
        registerResponseCall.enqueue(object : Callback<ModelRegisterResponseRemote> {
            override fun onFailure(call: Call<ModelRegisterResponseRemote>?, t: Throwable?) {
                Log.d("Error", t?.message.toString())

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



