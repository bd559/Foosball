package com.example.foosball.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foosball.data.models.FoosballMatch
import com.example.foosball.repositories.FoosballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoosballViewModel @Inject constructor(
    private val repository: FoosballRepository
): ViewModel() {

    fun upsert(match: FoosballMatch) = viewModelScope.launch {
        repository.upsert(match)
    }

    fun delete(match: FoosballMatch) =  viewModelScope.launch {
        repository.delete(match)
    }

    val allFoosballMatches = repository.getAllFoosballMatches()
}