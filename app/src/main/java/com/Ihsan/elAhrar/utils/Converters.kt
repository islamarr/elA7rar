package com.Ihsan.elAhrar.utils

import androidx.room.TypeConverter
import com.Ihsan.elAhrar.data.entity.ReasonsModel
import com.Ihsan.elAhrar.data.entity.ResetDateModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun storedStringToResetDate(data: String?): List<ResetDateModel> {
            val gson = Gson()
            if (data == null) {
                return Collections.emptyList()
            }
            val listType = object : TypeToken<List<ResetDateModel>>() {

            }.getType()
            return gson.fromJson<List<ResetDateModel>>(data, listType)
        }

        @TypeConverter
        @JvmStatic
        fun myObjectsToStoredResetDate(myObjects: List<ResetDateModel>): String {
            val gson = Gson()
            return gson.toJson(myObjects)
        }

        @TypeConverter
        @JvmStatic
        fun storedStringToReasons(data: String?): List<ReasonsModel> {
            val gson = Gson()
            if (data == null) {
                return Collections.emptyList()
            }
            val listType = object : TypeToken<List<ReasonsModel>>() {

            }.getType()
            return gson.fromJson<List<ReasonsModel>>(data, listType)
        }

        @TypeConverter
        @JvmStatic
        fun myObjectsToStoredReasons(myObjects: List<ReasonsModel>): String {
            val gson = Gson()
            return gson.toJson(myObjects)
        }


    }

}