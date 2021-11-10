package com.ims.bottomnav_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.ims.bottomnav_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        loadFragment(Profileragment())


        binding.bottomNavView.setOnNavigationItemSelectedListener { menuItem : MenuItem ->
            when (menuItem.itemId) {
                R.id.menu_explore -> {
                    loadFragment(ExploreFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_dashboard -> {
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    loadFragment(Profileragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }


    }


    private fun loadFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().also{
            fragmentTransaction: FragmentTransaction ->
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        }

    }
}