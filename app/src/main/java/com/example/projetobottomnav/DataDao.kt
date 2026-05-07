package com.example.projetobottomnav

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {

    @Insert
    suspend fun insertChannel(data: DataClass)

    @Query("SELECT * FROM channels")
    suspend fun getAllChannels(): List<DataClass>

    @Query("DELETE FROM channels")
    suspend fun deleteAll()
}