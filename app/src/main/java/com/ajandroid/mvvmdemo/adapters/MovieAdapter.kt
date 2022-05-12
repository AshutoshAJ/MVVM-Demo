package com.ajandroid.mvvmdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajandroid.mvvmdemo.databinding.ListItemBinding
import com.ajandroid.mvvmdemo.models.Movie
import com.bumptech.glide.Glide

class MovieAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MyViewHolder(private val listItemBinding: ListItemBinding): RecyclerView.ViewHolder(listItemBinding.root) {

    fun bind(movie: Movie) {
        Log.d("X", movie.toString())
        listItemBinding.titleTextView.text = movie.title
        listItemBinding.descriptionTextView.text = movie.overview

        val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
        Glide.with(listItemBinding.posterImageView.context)
            .load(posterURL)
            .into(listItemBinding.posterImageView)
    }

}