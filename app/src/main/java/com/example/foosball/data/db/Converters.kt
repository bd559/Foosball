package com.example.foosball.data.db

import androidx.room.TypeConverter
import com.example.foosball.data.models.Score
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Converters {

    @TypeConverter
    fun scoreToString(player: Score): String {
        val adapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Score::class.java)
        return adapter.toJson(player)
    }
    @TypeConverter
    fun stringToScore(jsonString: String): Score? {
        val adapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Score::class.java)
        return adapter.fromJson(jsonString)
    }
}