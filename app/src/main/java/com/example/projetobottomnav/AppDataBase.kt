package com.example.projetobottomnav

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataClass::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao
}