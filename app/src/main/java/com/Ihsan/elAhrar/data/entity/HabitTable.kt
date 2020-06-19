package com.Ihsan.elAhrar.data.entity

import androidx.room.PrimaryKey


data class HabitTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String?,
    var type: String?,
    var icon: Int?,
    var savedTime: Int?,
    var savedMoney: Int?,
    var startDate: Long?,
    var resetDate: List<ResetDateModel>,
    var reasons: List<ReasonsModel>
)