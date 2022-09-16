package com.app.lerp.retoapp.ui.movie

import android.content.Intent
import android.os.Bundle
import com.app.lerp.retoapp.base.BaseActivity
import com.app.lerp.retoapp.databinding.ActivityMovieBinding

class MovieActivity : BaseActivity() {
    private lateinit var binding: ActivityMovieBinding

    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {
        //Solo se usa cuando necesitamos el startActivityResult
    }

    override fun initView() {
        //TODO("Not yet implemented")
    }

    override fun initViewModel() {
        //TODO("Not yet implemented")
    }
}