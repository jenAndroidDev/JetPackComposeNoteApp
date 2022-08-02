package com.jenin.jetpackcomposenoteapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass
import com.jenin.jetpackcomposenoteapp.repository.NoteRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRespository: NoteRespository):ViewModel() {

    private val _noteList = MutableStateFlow<List<NoteDataClass>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRespository.getAllNotes().distinctUntilChanged().collect{ values->
                _noteList.value = values
            }
        }
    }

     fun addNote(noteDataClass: NoteDataClass) = viewModelScope.launch {
        noteRespository.insertNotes(noteDataClass)
    }

     fun updateNote(noteDataClass: NoteDataClass) = viewModelScope.launch {
        noteRespository.updateNote(noteDataClass)
    }

    fun deleteNote() = viewModelScope.launch {
        noteRespository.deleteAllNotes()
    }

    fun deleteNoteById(id:Int) = viewModelScope.launch {
        noteRespository.deleteNoteById(id)
    }


}