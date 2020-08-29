package com.Ihsan.elAhrar.data

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.Ihsan.elAhrar.data.dao.HabitDao
import com.Ihsan.elAhrar.data.database.UnitHabit

class HabitRepository(context: Context?) {
    private val habitDao: HabitDao


    init {
        habitDao = ElAhrarDataBase.invoke(context!!).HabitDao()
    }

    fun getAllHabits(): LiveData<List<UnitHabit>> {
        return habitDao.getAllHabits()
    }

    fun getmHabit(id: Int): LiveData<UnitHabit> {
        return habitDao.getHabit(id)
    }

    fun insert(habit: UnitHabit?) {
        insertAsyncTask(habitDao).execute(habit)
    }

    fun deleteOne(habit: UnitHabit?) {
        habitDao.deleteOne(habit!!)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: HabitDao) :
        AsyncTask<UnitHabit?, Void?, Void?>() {
        protected override fun doInBackground(vararg params: UnitHabit?): Void? {
            mAsyncTaskDao.addHabit(params[0]!!)
            return null
        }

    }

}