package com.app.lerp.retoapp.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.DataMovie
import com.app.lerp.entity.MovieData
import com.app.lerp.retoapp.databinding.ItemMovieBinding
import com.app.lerp.retoapp.ui.movie.holder.MovieHolder


class MovieAdapter(
    private var onClickInspection: (route: MovieData) -> Unit
) : RecyclerView.Adapter<MovieHolder>() {

    private var items: List<MovieData> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val inspectionEntity= items[position]
        holder.bindView(inspectionEntity,onClickInspection)
    }

    override fun getItemCount() = items.size

    fun updateList(listInspection: List<MovieData>) {
        items = listInspection
        notifyDataSetChanged()
    }

}