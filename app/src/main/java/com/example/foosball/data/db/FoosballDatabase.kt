package com.example.foosball.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foosball.data.models.FoosballMatch

@Database(
    entities = [FoosballMatch::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FoosballDatabase: RoomDatabase() {

    abstract fun getFoosballDao() : FoosballDao
}