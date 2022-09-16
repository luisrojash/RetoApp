package com.app.lerp.retoapp.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.core.util.EndlessOnScrollListener
import com.app.lerp.entity.MovieData
import com.app.lerp.retoapp.base.BaseActivity
import com.app.lerp.retoapp.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieActivity : BaseActivity() {
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by (this as FragmentActivity).viewModels()

    /*Attrib Load More*/
    private var mCurrentPage = 1
    private var mCountEnd = 0
    private var totalPage = 0

    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {
        //Solo se usa cuando necesitamos el startActivityResult
    }

    override fun initView() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = linearLayoutManager
        adapter = MovieAdapter {
            onClickDetail(it)
        }
        binding.recycler.adapter = adapter

        val paginationScrollListener = object : EndlessOnScrollListener(linearLayoutManager) {
            override fun loadMoreItems(page: Int, totalItemsCount: Int) {
                showProgressDialog()
                if (mCountEnd != totalItemsCount) {
                    val totalitemCount = linearLayoutManager.itemCount
                    Log.i("MOvieActivity ", "linearLayoutManager.itemCount" + totalitemCount)
                    if (mCountEnd != totalitemCount) {
                        if (mCurrentPage == totalPage) {
                            return
                        }
                        mCurrentPage += 1
                        Log.i("MOvieActivity ", "mCurrentPage" + mCurrentPage)
                        initViewModel()
                    }
                    mCountEnd = totalitemCount
                    Log.i("MOvieActivity ", "totalItemsCounts" + totalitemCount)
                }
                Log.i("MOvieActivity ", "totalItemsCounttotalItemsCount" + totalItemsCount)
            }
        }
        binding.recycler.addOnScrollListener(paginationScrollListener)
    }

    private fun onClickDetail(it: MovieData) {

    }

    override fun initViewModel() {
        viewModel.getListMovie(mCurrentPage)
    }

    override fun initViewObserver() {

        viewModel.movieLiveData.observe(this) {
            when (it) {
                is MoviewEventResult.ShowListInspection -> {
                    hideProgressDialog()
                    totalPage = it.data.totalPages
                    adapter.updateList(it.data.results)
                }
                is MoviewEventResult.Error -> {
                    hideProgressDialog()
                }
                else -> {}
            }
        }
    }
}