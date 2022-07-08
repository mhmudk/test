package com.example.task.LoginRetrofit

import com.example.task.LoginRetrofit.LogInRequest.LogInRequest
import com.example.task.LoginRetrofit.ReqisterRequest.newregister.ModelRegisterResponseRemote

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsreService {
    @FormUrlEncoded
    @POST("user/signin")
    fun logInUser(@FieldMap map: HashMap<String, String?>?): Call<LogInRequest>

    @FormUrlEncoded
    @POST("users/register")
    fun RegisterUser(@FieldMap map: HashMap<String, String?>?): Call<ModelRegisterResponseRemote>


}