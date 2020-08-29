package com.Ihsan.elAhrar.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.data.HabitViewModel
import kotlinx.android.synthetic.main.activity_habit_details.*

class HabitDetails : AppCompatActivity() {

    private val habitViewModel: HabitViewModel by viewModels()
    private val TAG = "HabitDetails"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_details)

        var intent = getIntent()
        if (intent != null) {
            var id = intent.getIntExtra("id", -1)
            habitViewModel.getmHabit(id).observe(this, Observer {
                habitName.setTitle(it.name)
            })
        }

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