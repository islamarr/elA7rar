package com.Ihsan.elAhrar.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class UnitHabit(

    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "type")
    var type: String? = null,
    @ColumnInfo(name = "icon")
    var icon: Int? = 0,
    @ColumnInfo(name = "savedTime")
    var savedTime: Int? = 0,
    @ColumnInfo(name = "savedMoney")
    var savedMoney: Int? = 0,
    @ColumnInfo(name = "startDate")
    var startDate: Long? = 0,
    @ColumnInfo(name = "resetDate")
    var resetDate: String? = null,
    @ColumnInfo(name = "reasons")
    var reasons: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}