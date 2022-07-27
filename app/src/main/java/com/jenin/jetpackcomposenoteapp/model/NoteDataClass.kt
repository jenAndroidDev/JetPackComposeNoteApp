package com.jenin.jetpackcomposenoteapp.model

import java.time.LocalDateTime
import java.util.*

data class NoteDataClass(

    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDateTime: String
)
