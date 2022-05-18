package com.ajandroid.mvvmdemo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajandroid.mvvmdemo.data.repository.Repository
import com.ajandroid.mvvmdemo.ui.main.viewmodels.MoviesViewModel
import java.lang.IllegalArgumentException

class MoviesViewModelFactory constructor(
    private val repository: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            MoviesViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}