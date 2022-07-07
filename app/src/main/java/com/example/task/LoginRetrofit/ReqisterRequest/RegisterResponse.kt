package com.example.task.LoginRetrofit.ReqisterRequest

data class RegisterResponse(
    val email: String,
    val name: String,
    val password: String,
    val phone: String
)