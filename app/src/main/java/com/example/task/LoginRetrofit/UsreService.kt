package com.example.task.LoginRetrofit

import com.example.task.LoginRetrofit.LogInRequest.LogInRequest
import com.example.task.LoginRetrofit.LogInRequest.LogInResponse
import com.example.task.LoginRetrofit.ReqisterRequest.RegisterResponse
import com.example.task.LoginRetrofit.ReqisterRequest.ReqisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsreService {

    @POST("singin")
    fun logInUser(@Body logInRequest: LogInRequest): Call<LogInResponse>

    @POST("user_info")
    fun RegisterUser(@Body registerrequest: ReqisterRequest): Call<RegisterResponse>
}