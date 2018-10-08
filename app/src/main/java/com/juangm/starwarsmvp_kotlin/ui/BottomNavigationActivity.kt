package com.juangm.starwarsmvp_kotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.ui.characters.CharactersFragment
import com.juangm.starwarsmvp_kotlin.ui.planets.PlanetsFragment
import com.juangm.starwarsmvp_kotlin.ui.starships.StarshipsFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        showFragment(PlanetsFragment())

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_planets -> {
                    showFragment(PlanetsFragment())
                    true
                }

                R.id.action_characters -> {
                    showFragment(CharactersFragment())
                    true
                }

                R.id.action_starships -> {
                    showFragment(StarshipsFragment())
                    true
                }

                else -> false
            }
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.navigation_placeholder, fragment)
                .commit()
    }
}