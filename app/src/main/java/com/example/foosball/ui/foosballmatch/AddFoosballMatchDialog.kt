package com.example.foosball.ui.foosballmatch

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.foosball.data.models.FoosballMatch
import com.example.foosball.data.models.Score
import com.example.foosball.databinding.DialogAddFoosballMatchBinding
import com.example.foosball.utils.createMatch
import com.example.foosball.utils.update

class AddFoosballMatchDialog(context: Context, private var addDialogListener: AddDialogListener, var match: FoosballMatch?) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddFoosballMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddFoosballMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            match?.let {
                etPlayerOne.setText(it.playerOne.player)
                etPlayerOneScore.setText(it.playerOne.points.toString())
                etPlayerTwo.setText(it.playerTwo.player)
                etPlayerTwoScore.setText(it.playerTwo.points.toString())
            }
            tvAdd.setOnClickListener {
                val playerOne = etPlayerOne.text.toString()
                val playerOneScore = etPlayerOneScore.text.toString().toIntOrNull()
                val playerTwo = etPlayerTwo.text.toString()
                val playerTwoScore = etPlayerTwoScore.text.toString().toIntOrNull()

                if(playerOne.isEmpty() || playerOneScore == null || playerTwo.isEmpty() || playerTwoScore == null) {
                    Toast.makeText(context, "Please enter all the information and confirm it is correct", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (match == null) {
                    match = createMatch(Score(playerOne, playerOneScore), Score(playerTwo, playerTwoScore))
                } else {
                    match!!.update(
                        playerOneName = playerOne,
                        playerOneScore = playerOneScore,
                        playerTwoName = playerTwo,
                        playerTwoScore = playerTwoScore
                    )
                }
                addDialogListener.onAddButtonClicked(match!!)
                dismiss()
            }

            tvCancel.setOnClickListener {
                cancel()
            }
        }
    }
}