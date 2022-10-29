package com.example.foosball.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foosball.data.models.Ranking

class RankingViewModel : ViewModel() {
    private val _rankings = MutableLiveData<List<Ranking>>()
    val rankings: LiveData<List<Ranking>> get() = _rankings

    fun sortByGameWon() {
        _rankings.postValue(rankings.value?.sortedByDescending { it.gamesWon } ?: emptyList())
    }

    fun sortByGamePlayed() {
        _rankings.postValue(rankings.value?.sortedByDescending { it.gamesPlayed } ?: emptyList())
    }

    fun getRankings(rankings: List<Ranking>) {
        _rankings.postValue(rankings)
    }
}