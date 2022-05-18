package com.ajandroid.mvvmdemo.data.repository

import com.ajandroid.mvvmdemo.BuildConfig
import com.ajandroid.mvvmdemo.data.models.MoviesList
import com.ajandroid.mvvmdemo.data.api.RetrofitService
import retrofit2.Call

class Repository constructor(
    private val retrofitService: RetrofitService
) {

    fun getAllMovies(): Call<MoviesList> = retrofitService.getPopularMovies(BuildConfig.API_KEY)

}