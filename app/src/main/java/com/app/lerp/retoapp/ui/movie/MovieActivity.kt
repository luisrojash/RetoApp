package com.app.lerp.retoapp.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.app.lerp.entity.DataMovie
import com.app.lerp.entity.MovieData
import com.app.lerp.retoapp.base.BaseActivity
import com.app.lerp.retoapp.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : BaseActivity() {
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by (this as FragmentActivity).viewModels()
    private var page = 1


    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {
        //Solo se usa cuando necesitamos el startActivityResult
    }

    override fun initView() {
        adapter = MovieAdapter {
            onClickDetail(it)
        }
        binding.recycler.adapter = adapter
        //adapterInspection.updateList(listInspection)
    }

    private fun onClickDetail(it: MovieData) {

    }

    override fun initViewModel() {
        viewModel.getListMovie(page)
    }

    override fun initViewObserver() {
        viewModel.movieLiveData.observe(this) {
            //binding.layoutLoading.progress.isVisible = it is RouteListEventResult.Loading
            when (it) {
                is MoviewEventResult.ShowListInspection -> {
                    hideProgressDialog()
                    adapter.updateList(it.listMovies)
                }
                is MoviewEventResult.Error -> {
                    hideProgressDialog()
                }
                else -> {}
            }
        }
    }
}