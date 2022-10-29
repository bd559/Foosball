package com.example.foosball.ui.foosballmatch

import com.example.foosball.data.models.FoosballMatch

interface AddDialogListener {
    fun onAddButtonClicked(match: FoosballMatch)
}