package com.android.notesapp.viewmodel
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.android.notesapp.model.Note


class NoteViewModel : ViewModel(){

    var noteList = mutableStateListOf<Note>()


}