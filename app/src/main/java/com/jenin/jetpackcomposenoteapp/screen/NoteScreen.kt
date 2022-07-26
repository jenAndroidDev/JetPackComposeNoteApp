package com.jenin.jetpackcomposenoteapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jenin.jetpackcomposenoteapp.R
import com.jenin.jetpackcomposenoteapp.components.NoteButton
import com.jenin.jetpackcomposenoteapp.components.NoteInputText
import com.jenin.jetpackcomposenoteapp.ui.theme.LightGreySample

@Composable
fun NoteScreen(){

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
               onClick = { /*TODO*/ })



       }

   }

}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}