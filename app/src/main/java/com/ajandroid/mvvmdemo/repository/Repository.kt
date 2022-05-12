package com.ajandroid.mvvmdemo.repository

import com.ajandroid.mvvmdemo.BuildConfig
import com.ajandroid.mvvmdemo.models.MoviesList
import com.ajandroid.mvvmdemo.networkutils.RetrofitService
import retrofit2.Call

class Repository constructor(
    private val retrofitService: RetrofitService
) {

    fun getAllMovies(): Call<MoviesList> = retrofitService.getPopularMovies(BuildConfig.API_KEY)

}