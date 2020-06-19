package com.Ihsan.elAhrar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Ihsan.elAhrar.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addHabitBtn.setOnClickListener {
            startActivity(Intent(this, HabitDetails::class.java))
        }
    }
}