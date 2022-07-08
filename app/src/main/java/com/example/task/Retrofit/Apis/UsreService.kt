package com.example.task.Retrofit.Apis

import com.example.task.Retrofit.RegisterUser.ModelRegisterResponseRemote
import com.example.task.Retrofit.LoginApi.LogInRequest

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsreService {
    @FormUrlEncoded
    @POST("users/login")
    fun logInUser(@FieldMap map: HashMap<String, String?>?): Call<LogInRequest>

    @FormUrlEncoded
    @POST("users/register")
    fun RegisterUser(@FieldMap map: HashMap<String, String?>?): Call<ModelRegisterResponseRemote>


}