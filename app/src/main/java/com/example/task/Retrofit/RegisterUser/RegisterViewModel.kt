package com.example.task.Retrofit.RegisterUser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    val repo = RegisterRepo()
    fun getResponseUser(loginrequest: HashMap<String, String?>): MutableLiveData<ModelRegisterResponseRemote> {
        return repo.register(loginrequest)
    }

}