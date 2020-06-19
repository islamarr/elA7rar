package com.Ihsan.elAhrar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.Ihsan.elAhrar.data.dao.HabitDao
import com.Ihsan.elAhrar.data.database.UnitHabit
import com.Ihsan.elAhrar.data.entity.HabitTable
import com.Ihsan.elAhrar.utils.Converters


@Database(
    entities = [UnitHabit::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ElAhrarDataBase : RoomDatabase() {

    abstract fun HabitDao(): HabitDao


    companion object {
        @Volatile
        private var instance: ElAhrarDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: buildDatabase(context).also { instance = it }
        }


        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ElAhrarDataBase::class.java,
                "elAhrar.db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }


}