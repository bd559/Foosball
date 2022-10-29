package com.example.foosball.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foosball_match")
data class FoosballMatch(
    @ColumnInfo(name = "winner")
    var winner: String,
    @ColumnInfo(name = "player_one")
    var playerOne: Score,
    @ColumnInfo(name = "player_two")
    var playerTwo: Score
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
