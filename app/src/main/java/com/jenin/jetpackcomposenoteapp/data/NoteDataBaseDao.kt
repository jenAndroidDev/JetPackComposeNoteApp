package com.jenin.jetpackcomposenoteapp.data

import androidx.room.*
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDao {

    @Query("SELECT * FROM NoteDataClass")
    fun getNotes(): Flow<List<NoteDataClass>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(noteDataClass: NoteDataClass)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(noteDataClass: NoteDataClass)

    @Query("DELETE FROM NoteDataClass")
    suspend fun deleteAll()

    @Query("DELETE FROM NoteDataClass where id=:id")
    suspend fun deleteNotes(id:Int)
}