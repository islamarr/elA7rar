package com.Ihsan.elAhrar.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.data.HabitViewModel
import com.Ihsan.elAhrar.data.dao.HabitDao
import com.Ihsan.elAhrar.ui.adapters.HabitAdapter
import com.Ihsan.elAhrar.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var todayQuot: Array<String>
    lateinit var author: Array<String>
    private val habitViewModel: HabitViewModel by viewModels()
    lateinit var habitAdapter: HabitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        habitRecycler.layoutManager = LinearLayoutManager(this)
        val levels = resources.getIntArray(R.array.levels_timeInMilliSec).toList()
        habitAdapter = HabitAdapter(this, listOf(), habitViewModel)
        habitRecycler.adapter = habitAdapter

        habitViewModel.getmAllHabits().observe(this, Observer {
            habitAdapter.habitList = it
            habitAdapter.notifyDataSetChanged()
        })

        addHabitBtn.setOnClickListener {
            startActivity(Intent(this, CreateHabit::class.java))
        }

        More.setOnClickListener {
            showPopup()
        }

        todayQuot = resources.getStringArray(R.array.todayQuot)
        author = resources.getStringArray(R.array.author)
        val quotText = todayQuot[Utils.getDayOfYear() - 1]
        val quotAuthor = author[Utils.getDayOfYear() - 1]
        Quot.text = quotText
        Author.text = quotAuthor
    }

    private fun showPopup() {
        val contextThemeWrapper =
            ContextThemeWrapper(this, R.style.PopupMenuOverlapAnchor)
        val popupMenu = PopupMenu(contextThemeWrapper, More)
        popupMenu.menuInflater.inflate(R.menu.popup_general, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.share -> {
                    Toast.makeText(this, "ssssssssssshare", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    override fun onStop() {
        super.onStop()
        habitAdapter.removeHandler()
    }
}