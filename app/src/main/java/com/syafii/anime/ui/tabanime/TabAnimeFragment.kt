package com.syafii.anime.ui.tabanime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.syafii.anime.R
import com.syafii.anime.databinding.FragmentTabAnimeBinding
import com.syafii.anime.ui.home.adapter.ViewPagerAdapter
import com.syafii.anime.ui.movie.MovieFragment
import com.syafii.anime.ui.nonmovie.NonMovieFragment

class TabAnimeFragment : Fragment() {

    private lateinit var binding : FragmentTabAnimeBinding
    private val pagerAdapter: ViewPagerAdapter by lazy { ViewPagerAdapter(requireActivity()) }
    private val tabTitle = arrayOf(
        "Movie",
        "Non Movie"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTabAnimeBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        pagerAdapter.addFragment(MovieFragment())
        pagerAdapter.addFragment(NonMovieFragment())
        binding.vpAnime.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.vpAnime) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }


}
