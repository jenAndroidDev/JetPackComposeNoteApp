package com.jenin.jetpackcomposenoteapp.repository

import com.jenin.jetpackcomposenoteapp.data.NoteDataBaseDao
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import java.net.IDN
import javax.inject.Inject

class NoteRespository @Inject constructor(val noteDataBaseDao: NoteDataBaseDao){

    fun insertNotes(noteDataClass: NoteDataClass) = CoroutineScope(Dispatchers.IO).launch {
        noteDataBaseDao.insertNotes(noteDataClass)
    }

    fun updateNote(noteDataClass: NoteDataClass) = CoroutineScope(Dispatchers.IO).launch {
        noteDataBaseDao.updateNote(noteDataClass)
    }

    fun deleteNoteById(id:Int) = CoroutineScope(Dispatchers.IO).launch {
        noteDataBaseDao.deleteNotes(id = id)
    }

    fun deleteAllNotes() = CoroutineScope(Dispatchers.IO).launch {
        noteDataBaseDao.deleteAll()
    }

    fun getAllNotes():Flow<List<NoteDataClass>> = runBlocking {
        val result = async { noteDataBaseDao.getNotes() }.await()
        return@runBlocking result
    }

}