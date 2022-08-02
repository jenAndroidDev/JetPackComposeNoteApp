package com.jenin.jetpackcomposenoteapp.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jenin.jetpackcomposenoteapp.data.NoteDataBaseDao
import com.jenin.jetpackcomposenoteapp.local.TypeConverter.DatabaseTypeConverter
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass

@Database(entities = arrayOf(NoteDataClass::class), version = 1, exportSchema = false)
@TypeConverters(DatabaseTypeConverter::class)
abstract class AppDb:RoomDatabase() {

    abstract fun noteDao():NoteDataBaseDao

}