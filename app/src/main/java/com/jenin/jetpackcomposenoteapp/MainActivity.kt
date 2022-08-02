package com.jenin.jetpackcomposenoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jenin.jetpackcomposenoteapp.data.loadNotes
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass
import com.jenin.jetpackcomposenoteapp.screen.NoteScreen
import com.jenin.jetpackcomposenoteapp.ui.theme.JetPackComposeNoteAppTheme
import com.jenin.jetpackcomposenoteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeNoteAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)
                }
            }
        }
    }
    @ExperimentalComposeUiApi
    @Composable
    fun NotesApp(noteViewModel: NoteViewModel){

        val notesList = noteViewModel.noteList.collectAsState().value

        NoteScreen(
            context = this,
            note = notesList,
            onAddNote = {noteViewModel.addNote(it)},
            onRemoveNote = {noteViewModel.deleteNote()} )

    }
}