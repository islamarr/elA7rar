package com.Ihsan.elAhrar.utils

import com.Ihsan.elAhrar.model.RemainingTime
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun getRemainingtime(time: Long): RemainingTime{
        var time = time / 1000
        val days = time / (24 * 3600)

        time %= (24 * 3600)
        val hours = time / 3600

        time %= 3600
        val minutes = time / 60

        time %= 60
        val seconds: Long = time

        return RemainingTime(days, hours, minutes, seconds)
    }

    fun getRemainingtimeStr(remainingTime: RemainingTime): String{
        return "${remainingTime.days} : ${remainingTime.hours} : ${remainingTime.minutes} : ${remainingTime.seconds}"
    }

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