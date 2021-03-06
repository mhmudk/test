package com.example.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.task.Pojo.Const
import com.example.task.RegisterActivity.Registration


class SplachScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)

        val preferences: SharedPreferences =
            applicationContext.getSharedPreferences("token", Context.MODE_PRIVATE)
        val retrivedToken = preferences.getString(Const.TOKEN, null)

        Handler().postDelayed({
            if (retrivedToken != null) {
                startActivity(Intent(this, MainActivity::class.java))

            } else {
                startActivity(Intent(this, Registration::class.java))
            }
        }, 2000)


    }
}