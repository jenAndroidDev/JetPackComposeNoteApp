package com.jenin.jetpackcomposenoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.jenin.jetpackcomposenoteapp.data.loadNotes
import com.jenin.jetpackcomposenoteapp.module.NoteDataClass
import com.jenin.jetpackcomposenoteapp.screen.NoteScreen
import com.jenin.jetpackcomposenoteapp.ui.theme.JetPackComposeNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeNoteAppTheme {
                // A surface container using the 'background' color from the theme
                val notes = remember{
                    mutableListOf<NoteDataClass>()
                }
                Surface(color = MaterialTheme.colors.background) {
                      NoteScreen(
                          context = this@MainActivity,
                          note = notes,
                          onAddNote = {addNote->
                              notes.add(addNote)
                          },
                          onRemoveNote = {removeNote->
                            notes.remove(removeNote)
                          })
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetPackComposeNoteAppTheme {
            NoteScreen(context = this@MainActivity, note = loadNotes(),{},{})
        }
    }
}