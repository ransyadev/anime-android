package com.syafii.anime.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayoutMediator
import com.syafii.anime.R
import com.syafii.anime.databinding.ActivityMainBinding
import com.syafii.anime.ui.home.adapter.ViewPagerAdapter
import com.syafii.anime.ui.movie.MovieFragment
import com.syafii.anime.ui.nonmovie.NonMovieFragment
import com.syafii.anime.ui.tabanime.TabAnimeFragment

class MainActivity : AppCompatActivity() , NavigationBarView.OnItemSelectedListener{
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.bottomNavigation.setOnItemSelectedListener(this)
        selectActiveTabs(binding.bottomNavigation.selectedItemId)
    }

    private fun selectActiveTabs(itemId: Int) {
        when(itemId){
            R.id.nav_non_movie -> {
                loadFragment(fragment = NonMovieFragment())
            }
            R.id.nav_tab_anime -> {
                loadFragment(fragment = TabAnimeFragment())
            }
            else -> {
                loadFragment(fragment = MovieFragment())
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectActiveTabs(item.itemId)
       return true
    }


    private fun loadFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

}
