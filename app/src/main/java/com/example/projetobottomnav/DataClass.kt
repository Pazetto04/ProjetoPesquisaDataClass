package com.example.projetobottomnav

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class DataClass(

    @PrimaryKey(autoGenerate = true)
    val dataImage: Int,
    val dataTitle: String,
    val dataId: String
)
