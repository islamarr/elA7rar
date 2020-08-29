package com.Ihsan.elAhrar.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.Ihsan.elAhrar.data.database.UnitHabit

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHabit(unitHabit: UnitHabit)

    @Query("select * from habit")
    fun getAllHabits(): LiveData<List<UnitHabit>>

    @Query("select * from habit where id = :Id")
    fun getHabit(Id: Int): LiveData<UnitHabit>

    @Delete
    fun deleteOne(unitHabit: UnitHabit)

    @Query("DELETE FROM habit")
    fun deleteAll()
}