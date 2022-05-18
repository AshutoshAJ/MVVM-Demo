package com.ajandroid.mvvmdemo.ui.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajandroid.mvvmdemo.data.models.Movie
import com.ajandroid.mvvmdemo.data.models.MoviesList
import com.ajandroid.mvvmdemo.data.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel(
    private val repository: Repository
): ViewModel() {

    val moviesList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<MoviesList> {
            override fun onResponse(
                call: Call<MoviesList>,
                response: Response<MoviesList>
            ) {
                moviesList.postValue(response.body()?.movies!!)
            }

            override fun onFailure(call: Call<MoviesList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }


        })

    }

}