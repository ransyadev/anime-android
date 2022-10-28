package com.syafii.anime.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syafii.anime.databinding.ItemMovieBinding
import com.syafii.anime.model.Anime


class MovieAdapter : ListAdapter<Anime, MovieAdapter.MovieViewHolder>(MovieDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }


    class MovieViewHolder(val binding : ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : Anime){
            binding.run {
                sivMovie.setImageResource(data.img)
                tvTitle.text = data.title
                tvDesc.text = data.desc
            }
        }
    }


    class MovieDiffCallBack : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
           return oldItem.no == newItem.no
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem == newItem
        }

    }

}
