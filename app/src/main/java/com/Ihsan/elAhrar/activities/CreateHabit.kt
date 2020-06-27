package com.Ihsan.elAhrar.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.data.HabitViewModel
import com.Ihsan.elAhrar.data.database.UnitHabit
import com.Ihsan.elAhrar.utils.Utils
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog
import kotlinx.android.synthetic.main.activity_create_habit.*
import java.util.*


class CreateHabit : AppCompatActivity() {

    private val habitViewModel: HabitViewModel by viewModels()
    var unitHabit = UnitHabit()
    var isValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)

        setHabitDate(System.currentTimeMillis())


        habitStartTime.setOnClickListener {
            SingleDateAndTimePickerDialog.Builder(this)
                .mainColor(Color.RED)
                .titleTextColor(Color.BLACK)
                .focusable()
                .customLocale(Locale("ar"))
                .title("choose last date")
                .listener {
                    setHabitDate(it.time)
                }.display()
        }

        doneBtn.setOnClickListener {
            validate()

            if (isValid) {
                habitViewModel.insert(unitHabit)
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun setHabitDate(time: Long) {
        unitHabit.startDate = time
        habitStartTime.setText( Utils.convertTimeToDate(time) )
    }

    private fun validate() {
        if (habitName.text.toString().isEmpty()) {
            isValid = false
            habitNameLayout.error = "must not null"
        } else {
            isValid = true
           unitHabit.name = habitName.text.toString()
        }

    }
}