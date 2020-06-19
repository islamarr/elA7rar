package com.Ihsan.elAhrar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.Ihsan.elAhrar.data.database.UnitHabit

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHabit(unitHabit: UnitHabit)

    @Query("select * from habit")
    fun getUnitHabit(): UnitHabit


    @Query("DELETE FROM habit")
    fun delete()
}