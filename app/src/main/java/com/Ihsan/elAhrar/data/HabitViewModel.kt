package com.Ihsan.elAhrar.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.Ihsan.elAhrar.data.database.UnitHabit

class HabitViewModel(application: Application?) : AndroidViewModel(application!!) {
    private val mRepository: HabitRepository = HabitRepository(application)
    private val mAllHabits: LiveData<List<UnitHabit>>
    fun getmAllHabits(): LiveData<List<UnitHabit>> {
        return mAllHabits
    }

    fun insert(unitHabit: UnitHabit?) {
        mRepository.insert(unitHabit)
    }

    fun deleteOne(unitHabit: UnitHabit?) {
        mRepository.deleteOne(unitHabit)
    }

    init {
        mAllHabits = mRepository.getAllHabits()
    }
}