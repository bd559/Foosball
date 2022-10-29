package com.example.foosball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foosball.data.models.FoosballMatch
import com.example.foosball.databinding.FoosballMatchItemBinding
import com.example.foosball.ui.foosballmatch.AddDialogListener
import com.example.foosball.ui.foosballmatch.AddFoosballMatchDialog
import com.example.foosball.ui.viewmodels.FoosballViewModel

class FoosballMatchAdapter(
    var matches: List<FoosballMatch>,
    private var viewModel: FoosballViewModel,
    private val listener: (match: FoosballMatch) -> Unit
): RecyclerView.Adapter<FoosballMatchAdapter.FoosballMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoosballMatchItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).let {
        FoosballMatchViewHolder(it).apply {
            it.btnUpdate.setOnClickListener { listener.invoke(matches[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: FoosballMatchViewHolder, position: Int) {
        holder.setFoosballMatch(matches[position], viewModel)
    }

    override fun getItemCount() = matches.size

    class FoosballMatchViewHolder(
        private val binding: FoosballMatchItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun setFoosballMatch(foosballMatch: FoosballMatch, viewModel: FoosballViewModel) = with(binding) {
            tvPlayerOne.text = foosballMatch.playerOne.player
            tvPlayerOneScore.text = foosballMatch.playerOne.points.toString()
            tvPlayerTwo.text = foosballMatch.playerTwo.player
            tvPlayerTwoScore.text = foosballMatch.playerTwo.points.toString()
            btnUpdate.setOnClickListener {
                AddFoosballMatchDialog(root.context,
                    object : AddDialogListener {
                        override fun onAddButtonClicked(match: FoosballMatch) {
                            viewModel.upsert(match)
                        }
                    }, foosballMatch).show()
            }
        }
    }
}