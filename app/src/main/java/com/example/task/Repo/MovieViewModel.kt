package com.example.task.Repo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.Movie
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    val mutabl = MutableLiveData<Movie>()
    val movieObj = RepoMovies()

//    fun getMoviesFromRemote(){
//   mutabl.postValue(        movieObj.getMovies())
//
//
//    }
    fun getMoviesFromRemot():MutableLiveData<Movie>{
     return    movieObj.getMovies()
    }













    fun getMovies() {

        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMove()
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movieModel = response.body()!!
                mutabl.postValue(movieModel)
            }
            // هتبحث عن ازاي تاخد الداتا اللي جايه من الاون ريسبونس و فيلير من جوا ريبو + ازاي الفيو موديل هيتعامل مع الريبو بعد ما تنتهي من الريبو

            // ملحوظه: نفس الكود لما اتكتب مباشرة في الفيوموديل و عملنا البوست فاليو جوا الفيو موديل جوا الاون ريسبونس الداتا جت عادي
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }


        })
    }
}