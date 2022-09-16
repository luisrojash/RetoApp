package com.app.lerp.retoapp.ui.movie.holder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.DataMovie
import com.app.lerp.entity.MovieData
import com.app.lerp.retoapp.R
import com.app.lerp.retoapp.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MovieHolder(val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindView(
        movieData: MovieData,
        onClickInspection: (route: MovieData) -> Unit
    ) {
        Log.i("MOvieHolder ", " data " + movieData.image)
        val imagePath =  movieData.image
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_reload)
            .error(R.drawable.ic_reload)
        Glide.with(binding.root).load(imagePath).apply(options).into(binding.imageMovie)
    }


}