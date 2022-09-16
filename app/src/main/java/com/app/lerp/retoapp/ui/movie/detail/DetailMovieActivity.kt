package com.app.lerp.retoapp.ui.movie.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.app.lerp.entity.MovieData
import com.app.lerp.retoapp.R
import com.app.lerp.retoapp.base.BaseActivity
import com.app.lerp.retoapp.databinding.ActivityDetailMovieBinding
import com.app.lerp.retoapp.databinding.ActivityMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailMovieBinding


    companion object {
        fun newInstance(context: Context, movieData: MovieData): Intent {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra("movieData", movieData)
            return intent
        }
    }

    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {

    }

    override fun initView() {
        val movieData = intent.extras?.getParcelable<MovieData>("movieData")
        movieData?.let {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_reload)
                .error(R.drawable.ic_reload)
            Glide.with(binding.root).load(it.image).apply(options).into(binding.imageMovie)
            binding.textViewNameMovie.text = it.title
            binding.textViewNotaMovie.text = it.note
            binding.textViewDateMovie.text = it.date
            binding.textViewResume.text = it.resume
        }
    }

    override fun initViewModel() {

    }

    override fun initViewObserver() {

    }
}