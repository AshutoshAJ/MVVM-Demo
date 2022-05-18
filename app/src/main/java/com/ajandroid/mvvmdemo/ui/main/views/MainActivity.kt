package com.ajandroid.mvvmdemo.ui.main.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajandroid.mvvmdemo.ui.main.adapters.MovieAdapter
import com.ajandroid.mvvmdemo.databinding.ActivityMainBinding
import com.ajandroid.mvvmdemo.data.api.RetrofitService
import com.ajandroid.mvvmdemo.data.repository.Repository
import com.ajandroid.mvvmdemo.ui.main.viewmodels.MoviesViewModel
import com.ajandroid.mvvmdemo.ui.base.MoviesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var retrofitService: RetrofitService
    private lateinit var adapter: MovieAdapter

    final val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = RetrofitService.getInstance()
        viewModel = ViewModelProvider(this, MoviesViewModelFactory(Repository(retrofitService)))[MoviesViewModel::class.java]

        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpRecyclerView() {

        adapter = MovieAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun setUpObservers() {
        viewModel.moviesList.observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "Error: $it")
        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllMovies()
        binding.progressBar.visibility = View.VISIBLE
    }

}