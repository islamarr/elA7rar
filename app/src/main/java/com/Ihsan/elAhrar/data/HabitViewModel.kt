package com.Ihsan.elAhrar.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.Ihsan.elAhrar.data.database.UnitHabit

class HabitViewModel(application: Application?) : AndroidViewModel(application!!) {
    private val mRepository: HabitRepository = HabitRepository(application)

    fun getmAllHabits(): LiveData<List<UnitHabit>> {
        return mRepository.getAllHabits()
    }

    fun insert(unitHabit: UnitHabit?) {
        mRepository.insert(unitHabit)
    }

    fun deleteOne(unitHabit: UnitHabit?) {
        mRepository.deleteOne(unitHabit)
    }

    fun getmHabit(id: Int): LiveData<UnitHabit> {
        return mRepository.getmHabit(id)
    }

}