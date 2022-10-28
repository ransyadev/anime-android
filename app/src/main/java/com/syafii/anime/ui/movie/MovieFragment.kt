package com.syafii.anime.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafii.anime.R
import com.syafii.anime.data.listMovie
import com.syafii.anime.databinding.FragmentMovieBinding
import com.syafii.anime.ui.movie.adapter.MovieAdapter


class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieBinding
    private val adapterMovie : MovieAdapter by lazy { MovieAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {
       binding.run {
           adapterMovie.submitList(listMovie)
           val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
           rvMovie.layoutManager = layoutManager
           rvMovie.adapter = adapterMovie
       }
    }


}
