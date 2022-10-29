package com.example.foosball.utils

import com.example.foosball.data.models.Score
import com.example.foosball.data.models.FoosballMatch

fun createMatch(playerOne: Score, playerTwo: Score): FoosballMatch {
    val winner = if(playerOne.points > playerTwo.points) {
        playerOne.player
    } else {
        playerTwo.player
    }
    return FoosballMatch(winner, playerOne, playerTwo)
}

fun createMatch(playerOne: String, playerOneScore: Int, playerTwo: String, playerTwoScore: Int): FoosballMatch {
    val winner = if(playerOneScore > playerTwoScore) {
        playerOne
    } else {
        playerTwo
    }
    return FoosballMatch(winner, Score(playerOne, playerOneScore), Score(playerTwo, playerTwoScore))
}

fun getDefaultMatches(): MutableList<FoosballMatch> {
    val matches = mutableListOf<FoosballMatch>()
    matches.addAll(arrayListOf(
        createMatch("Amos",2,"Diego",5),
        createMatch("Amos",0,"Diego",5),
        createMatch("Amos",6,"Diego",5),
        createMatch("Amos",5,"Diego",2),
        createMatch("Amos",4,"Diego",0),
        createMatch("Joel",4,"Diego",5),
        createMatch("Tim",4,"Amos",5),
        createMatch("Tim",5,"Amos",2),
        createMatch("Amos",3,"Tim",5),
        createMatch("Amos",5,"Tim",3),
        createMatch("Amos",5,"Joel",4),
        createMatch("Joel",5,"Tim",2))
    )
    return matches
}