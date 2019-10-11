package com.example.mynotesapp.helper

import android.database.Cursor
import com.example.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.example.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.example.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.example.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID

import com.example.mynotesapp.entity.Note

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor): ArrayList<Note> {
        val noteList = ArrayList<Note>()
        while (notesCursor.moveToNext()) {
            val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID))
            val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE))
            val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION))
            val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE))
            noteList.add(Note(id, title, description, date))
        }
        return noteList
    }
}