package com.android.notesapp.data

import com.android.notesapp.model.Note

class NoteDataSource{
    fun loadNotes(): List<Note>{
        return listOf(
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good life", description = "A dead end is just a good place to turn around."),
                Note(title = "Good Movie", description = "I'm gonna make him an offer he can't refuse."),
                Note(title = "Jetpack Compose", description = "Jetpack Compose is a modern toolkit for building native Android UI."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day."),
                Note(title = "Good day", description = "I get up every morning, and it's going to be a great day.")

        )
    }
}