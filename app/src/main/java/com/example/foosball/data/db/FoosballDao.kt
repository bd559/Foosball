package com.example.foosball.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foosball.data.models.FoosballMatch

@Dao
interface FoosballDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(match: FoosballMatch) // insert and update

    @Delete
    suspend fun delete(match: FoosballMatch)

    @Query("SELECT * FROM foosball_match")
    fun getAllFoosballMatches() : LiveData<List<FoosballMatch>>
}