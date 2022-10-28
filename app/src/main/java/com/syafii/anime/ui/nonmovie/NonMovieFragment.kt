package com.syafii.anime.ui.nonmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafii.anime.R
import com.syafii.anime.data.listNonMovie
import com.syafii.anime.databinding.FragmentNonMovieBinding
import com.syafii.anime.ui.nonmovie.adapter.NonMovieAdapter


class NonMovieFragment : Fragment() {

    private lateinit var binding : FragmentNonMovieBinding
    private val adapterNonMovie : NonMovieAdapter by lazy { NonMovieAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNonMovieBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {
        binding.run {
            adapterNonMovie.submitList(listNonMovie)
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvNonMovie.layoutManager = layoutManager
            rvNonMovie.adapter = adapterNonMovie
        }
    }
}
