package com.android.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.android.notesapp.model.Note
import com.android.notesapp.screen.NoteScreen
import com.android.notesapp.ui.theme.NotesAppTheme
import com.android.notesapp.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {

                val note = remember {
                    mutableStateListOf<Note>()
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    NoteScreen(notes = note,
                        onAddNote = {
                                    note.add(it)
                        },
                        onRemove = {
                            note.remove(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel){

}
