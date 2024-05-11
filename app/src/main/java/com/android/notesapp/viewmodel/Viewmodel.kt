package com.android.notesapp.viewmodel
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.android.notesapp.data.NoteDataSource
import com.android.notesapp.model.Note


class NoteViewModel : ViewModel(){

    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }
    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getNotes(): List<Note> {
        return noteList
    }


}