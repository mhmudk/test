package com.example.task.LoginRetrofit

import com.example.task.LoginRetrofit.LogInRequest.LogInRequest
import com.example.task.LoginRetrofit.ReqisterRequest.RegisterResponse
import com.example.task.LoginRetrofit.ReqisterRequest.ReqisterRequest
import com.example.task.LoginRetrofit.ReqisterRequest.newregister.ModelRegisterResponseRemote
import com.example.task.Pojo.Model
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsreService {

    @POST("user/signin")
    fun logInUser(@Body logInRequest: LogInRequest): Call<LogInRequest>

    @FormUrlEncoded
    @POST("users/register")
    fun RegisterUser(@FieldMap map: HashMap<String, String?>?): Call<ModelRegisterResponseRemote>


}