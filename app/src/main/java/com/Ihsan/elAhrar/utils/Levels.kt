package com.Ihsan.elAhrar.utils

import android.content.Context
import android.util.Log
import com.Ihsan.elAhrar.R

object Levels {

    fun getNextLevel(con: Context, time: Long) : Int {
        val levels = con.resources.getIntArray(R.array.levels_timeInMilliSec).toList()
        var finalLevel = 0
        for(level in levels){
            Log.d("zxccccc", "getNextLevel:  $level  $time")
            if (level >= time/ 1000) {
                finalLevel = level
                break
            }
        }
        return finalLevel
    }

    fun getNextLevelIndex(con: Context, time: Long) : String {
        val levels = con.resources.getIntArray(R.array.levels_timeInMilliSec)
        val timers = con.resources.getStringArray(R.array.levels_timer)
        return timers[levels.indexOf(time.toInt())]
    }

}