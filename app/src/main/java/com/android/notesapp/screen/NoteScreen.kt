package com.android.notesapp.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.notesapp.components.NoteButton
import com.android.notesapp.components.NoteInputText
import com.android.notesapp.data.NoteDataSource
import com.android.notesapp.model.Note
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemove: (Note) -> Unit
){
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

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
                onClick = {
                    if(title.isNotEmpty() && description.isNotEmpty()){

                        val newNote = Note(
                            title = title,
                            description = description,
                            entryDate = LocalDateTime.now()
                        )

                        onAddNote(newNote)

                        title = ""
                        description = ""

                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        Divider(modifier = Modifier.padding(10.dp))

        LazyColumn {
            items(notes){note ->
               NoteRow(note = note, onNoteClicked = {
                   onRemove(note)
               })
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit) {

    Surface(modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp,
        tonalElevation = 6.dp
    ) {
        Column(
            modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = note.description,
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotePreview() {
        NoteScreen(notes = NoteDataSource().loadNotes(),
            onAddNote = {},
            onRemove =  {}
        )
}