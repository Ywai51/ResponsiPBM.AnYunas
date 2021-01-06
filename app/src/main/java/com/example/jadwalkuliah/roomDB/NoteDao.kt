package com.example.jadwalkuliah.roomDB

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id=:note_id")
    suspend fun getNote(note_id : Int): List<Note>
}