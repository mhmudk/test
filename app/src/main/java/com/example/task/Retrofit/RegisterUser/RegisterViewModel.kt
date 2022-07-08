package com.example.task.Retrofit.RegisterUser

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.LogInActivity.LogIn
import com.example.task.Retrofit.LoginApi.LogInRequest
import com.example.task.Retrofit.LoginApi.RepoLoginUser

class RegisterViewModel :ViewModel() {
    val repo= RepoRegister()
    fun getResponseUser(loginrequest: HashMap<String, String?>): MutableLiveData<ModelRegisterResponseRemote> {
    return repo.register(loginrequest)
    }

}