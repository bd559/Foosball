package com.example.foosball.utils

import com.example.foosball.data.models.FoosballMatch
import com.example.foosball.data.models.Ranking

fun List<FoosballMatch>.getRankings() : MutableList<Ranking> {
    val rankings: MutableList<Ranking> = mutableListOf()

    forEach { match ->
        if(rankings.find { it.player == match.playerOne.player } == null) {
            rankings.add(Ranking(match.playerOne.player, 0, 1))
        } else {
            rankings.find { it.player == match.playerOne.player }?.addGamePlayed()
        }

        if(rankings.find { it.player == match.playerTwo.player } == null) {
            rankings.add(Ranking(match.playerTwo.player, 0, 1))
        } else {
            rankings.find { it.player == match.playerTwo.player }?.addGamePlayed()
        }
        rankings.find { it.player == match.winner }?.addWin()
    }
    return rankings
}

fun Ranking.addGamePlayed() {
    this.gamesPlayed++
}

fun Ranking.addWin() {
    this.gamesWon++
}

fun FoosballMatch.update(playerOneName: String, playerOneScore: Int, playerTwoName: String, playerTwoScore: Int) {
    playerOne.player = playerOneName
    playerOne.points = playerOneScore
    playerTwo.player = playerTwoName
    playerTwo.points = playerTwoScore
}