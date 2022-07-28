package com.jenin.jetpackcomposenoteapp.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class NoteDataClass(

    @PrimaryKey(autoGenerate = true)
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name="note_description")
    val description: String,
    @ColumnInfo(name = "note_entry_time")
    val entryDateTime: String
)
