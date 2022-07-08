package com.example.task.Retrofit.LoginApi
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.task.Retrofit.Builder.BuilderApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoLoginUser(var statueResponse: State) {
    lateinit var context: Context
    fun logInRequestUser(loginrequest: HashMap<String, String?>) :MutableLiveData<LogInRequest>{
        var mutable = MutableLiveData<LogInRequest>()
        val loginrequestCall: Call<LogInRequest> =
            BuilderApiClient().getService().logInUser(loginrequest)
        loginrequestCall.enqueue(object : Callback<LogInRequest> {
            override fun onResponse(call: Call<LogInRequest>?, response: Response<LogInRequest>?) {
                if (response != null) {
                    mutable.postValue(response.body())
                    val preferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
                    preferences.edit().putString("TOKEN", response.body()!!.token).apply()
                    statueResponse.success()
                }
            }

            override fun onFailure(call: Call<LogInRequest>?, t: Throwable?) {
                if (t != null) {
                    statueResponse.Error(t.message.toString())
                }
            }


        })
return mutable
    }

    interface State {
        fun success()
        fun Error(error: String)
    }
}