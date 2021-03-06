package com.example.task.Retrofit.LoginApi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    val repo = LoginUserRepo()
    fun getResponseUser(loginrequest: HashMap<String, String?>): MutableLiveData<LogInRequest> {
        return repo.logInRequestUser(loginrequest)
    }

}