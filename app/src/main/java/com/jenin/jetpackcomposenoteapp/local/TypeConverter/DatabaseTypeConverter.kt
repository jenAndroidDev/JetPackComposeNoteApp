package com.jenin.jetpackcomposenoteapp.local.TypeConverter

import androidx.room.TypeConverter
import java.util.*

class DatabaseTypeConverter {

    @TypeConverter
    fun fromUUidToString(value: UUID):String{
        return value.toString()
    }

    @TypeConverter
    fun fromStringToUUId(value: String):UUID{
        return UUID.fromString(value)
    }
}