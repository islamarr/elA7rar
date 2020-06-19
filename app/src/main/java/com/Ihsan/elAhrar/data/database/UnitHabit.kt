package com.Ihsan.elAhrar.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class UnitHabit(

    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "type")
    var type: String?,
    @ColumnInfo(name = "icon")
    var icon: Int?,
    @ColumnInfo(name = "savedTime")
    var savedTime: Int?,
    @ColumnInfo(name = "savedMoney")
    var savedMoney: Int?,
    @ColumnInfo(name = "startDate")
    var startDate: Long?,
    @ColumnInfo(name = "resetDate")
    var resetDate: String?,
    @ColumnInfo(name = "reasons")
    var reasons: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}