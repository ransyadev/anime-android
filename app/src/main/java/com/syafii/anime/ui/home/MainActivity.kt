package com.syafii.anime.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.syafii.anime.databinding.ActivityMainBinding
import com.syafii.anime.ui.home.adapter.ViewPagerAdapter
import com.syafii.anime.ui.movie.MovieFragment
import com.syafii.anime.ui.nonmovie.NonMovieFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pagerAdapter: ViewPagerAdapter by lazy { ViewPagerAdapter(this) }
    private val tabTitle = arrayOf(
        "Movie",
        "Non Movie"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
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
