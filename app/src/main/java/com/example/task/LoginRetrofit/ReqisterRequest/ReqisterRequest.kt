package com.example.task.LoginRetrofit.ReqisterRequest

data class ReqisterRequest (
    var email : String,
    var name : String,
    var phone : String,
    var password : String,
) {
}