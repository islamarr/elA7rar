package com.Ihsan.elAhrar.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.data.ElAhrarDataBase
import com.Ihsan.elAhrar.data.dao.HabitDao
import com.Ihsan.elAhrar.data.database.UnitHabit
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var habitDao: HabitDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addHabitBtn.setOnClickListener {
            startActivity(Intent(this, CreateHabit::class.java))

         //   habitDao = ElAhrarDataBase.invoke(this).HabitDao()

         //   habitDao.addHabit(UnitHabit("eee","rrrrrr",22,21,21,3443434,"rrr","eee"))

        }

        More.setOnClickListener {
            showPopup()
        }
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
}