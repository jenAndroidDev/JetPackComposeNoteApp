package com.jenin.jetpackcomposenoteapp.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jenin.jetpackcomposenoteapp.R
import com.jenin.jetpackcomposenoteapp.components.NoteButton
import com.jenin.jetpackcomposenoteapp.components.NoteInputText
import com.jenin.jetpackcomposenoteapp.model.NoteDataClass
import com.jenin.jetpackcomposenoteapp.ui.theme.LightGreySample

@Composable
fun NoteScreen(
    context: Context,
    note:List<NoteDataClass>,
    onAddNote:(NoteDataClass)->Unit,
    onRemoveNote:(NoteDataClass)->Unit){

    var title by remember{
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }
    
   Column(modifier = Modifier.padding(6.dp)) {
       TopAppBar(
           title = { Text(text = stringResource(id = R.string.app_name))},
           actions = { Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "icon")},
           backgroundColor = LightGreySample)
       
       Column(modifier = Modifier.fillMaxWidth(),
              horizontalAlignment = Alignment.CenterHorizontally) {

          NoteInputText(

              text = title ,
              label = "Title",
              maxLine = 1,
              onTextChange = {textValue->
                if (textValue.all { char->
                    char.isLetter() || char.isWhitespace()
                    }
                ){
                    title = textValue
                }
              },
              modifier = Modifier.padding(8.dp))

           NoteInputText(
               text = description ,
               label = "Add a note",
               maxLine =1,
               onTextChange = {textValue->
                    if (textValue.all { char->
                        char.isLetter() || char.isWhitespace()
                        }) {
                        description = textValue
                    }
               },
               modifier = Modifier.padding(8.dp))

           NoteButton(
               text = "save",
               onClick = {
                   if(title.isNotEmpty() && description.isNotEmpty()){
                       onAddNote(NoteDataClass(title = title, description = description, entryDateTime = "29.07.1997"))
                       title = ""
                       description = ""
                       Toast.makeText(context,"NoteAdded",Toast.LENGTH_SHORT).show()

                   }
               })
       }
       Divider(modifier = Modifier.padding(10.dp))
       LazyColumn{
           items(note){notes->
               NoteRow(
                   noteDataClass = notes,
                   onNoteClicked = {
                    onRemoveNote.invoke(it)
                   })
           }
       }

   }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    //NoteScreen(note = emptyList(),{},{})
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    noteDataClass: NoteDataClass,
    onNoteClicked: (NoteDataClass)->Unit,

){

   Surface(
       modifier
           .padding(4.dp)
           .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
           .fillMaxWidth(),
          color = LightGreySample,
          elevation = 6.dp) {

        Column(
            modifier = Modifier
                .clickable {
                    onNoteClicked(noteDataClass)
                }
                .padding(horizontal = 14.dp, vertical = 6.dp)) {
            Text(
                text = noteDataClass.title,
                style = MaterialTheme.typography.subtitle2)
            Text(
                text = noteDataClass.description,
                style = MaterialTheme.typography.subtitle1)
            Text(
                text = noteDataClass.entryDateTime,
                style = MaterialTheme.typography.caption)
        }

   }

}