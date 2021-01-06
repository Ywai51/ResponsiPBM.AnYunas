package com.example.jadwalkuliah.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    val Id : Int,
    val title : String,
    val note : String

)