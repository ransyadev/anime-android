package com.syafii.anime.ui.nonmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syafii.anime.databinding.ItemNonMovieBinding
import com.syafii.anime.model.Anime

class NonMovieAdapter : ListAdapter<Anime, NonMovieAdapter.NonMovieViewHolder>(NonMovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonMovieViewHolder {
       return NonMovieViewHolder(ItemNonMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NonMovieViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }


    class NonMovieViewHolder(private val binding : ItemNonMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : Anime){
            binding.run {
                sivNonMovie.setImageResource(data.img)
                tvTitleNonMovie.text = data.title
                tvDescNonMovie.text = data.desc
            }
        }
    }



    class NonMovieDiffCallback : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.no == newItem.no
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem == newItem
        }

    }
}
