package com.Ihsan.elAhrar.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.Ihsan.elAhrar.R
import kotlinx.android.synthetic.main.activity_habit_details.*

class HabitDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_details)

        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_overview -> {
                    navController.navigate(R.id.navigation_overview)
                }
                R.id.navigation_trophies -> {
                    navController.navigate(R.id.navigation_trophies)
                }
                R.id.navigation_statistics -> {
                    navController.navigate(R.id.navigation_statistics)
                }
                R.id.navigation_motivation -> {
                    navController.navigate(R.id.navigation_motivation)
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

       /* val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_overview, R.id.navigation_motivation, R.id.navigation_statistics, R.id.navigation_trophies
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigation.setupWithNavController(navController)*/
    }
}