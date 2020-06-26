package com.Ihsan.elAhrar.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.Ihsan.elAhrar.R
import kotlinx.android.synthetic.main.activity_create_habit.*

class CreateHabit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)

        doneBtn.setOnClickListener {
            startActivity(Intent(this, HabitDetails::class.java))
        }
    }
}