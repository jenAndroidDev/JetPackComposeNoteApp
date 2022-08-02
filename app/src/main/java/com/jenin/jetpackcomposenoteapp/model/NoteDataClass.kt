package com.jenin.jetpackcomposenoteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class NoteDataClass (

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_tile")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_entry_date_time")
    val entryDateTime: String
){

}
