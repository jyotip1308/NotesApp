package com.android.notesapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.notesapp.components.NoteButton
import com.android.notesapp.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(){
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column (modifier = Modifier.padding(6.dp)){
        TopAppBar(title = {
                          Text(text = "Jet Note")
        },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon")
            },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xFFCBBECE))
        )

        //Content
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){

            Spacer(modifier = Modifier.height(12.dp))

            NoteInputText(text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                        char.isLetter() || char.isWhitespace()

                        }) title = it
                }
            )

            Spacer(modifier = Modifier.height(8.dp))
            NoteInputText(text = description,
                label = "Add a note",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()

                        }) description = it
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            NoteButton(text = "Save",
                onClick = { /*TODO*/ })

        }

    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
        NoteScreen()
}