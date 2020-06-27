package com.Ihsan.elAhrar.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun getDayOfYear(): Int {
        val calendar = Calendar.getInstance()
        val dayOfYear = calendar[Calendar.DAY_OF_YEAR]
        return if (dayOfYear <= 365) dayOfYear else 100
    }

    fun convertTimeToDate(time: Long): String {
        val date = Date(time)
        val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        return formatter.format(date)
    }
}