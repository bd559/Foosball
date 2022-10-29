package com.example.foosball.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ranking(
    val player: String,
    var gamesWon: Int,
    var gamesPlayed: Int,
) : Parcelable
