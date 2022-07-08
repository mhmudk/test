package com.example.task.Retrofit.LoginApi

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Details.RepoDetails
import com.example.task.MainActivity
import com.example.task.Pojo.MovieDetails

class LoginViewModel:ViewModel() ,RepoLoginUser.State{
    val repo  = RepoLoginUser(this)

    fun getResponseUser(loginrequest: HashMap<String, String?>):MutableLiveData<LogInRequest>{
        return repo.logInRequestUser(loginrequest)
    }
    override fun success() {
     //     Toast.makeText(, "Successfully", Toast.LENGTH_LONG).show()
        //   startActivity(Intent(this, MainActivity::class.java))
        //   startActivity(Intent(this, MainActivity::class.java))
    }

    override fun Error(error: String) {
    }
}