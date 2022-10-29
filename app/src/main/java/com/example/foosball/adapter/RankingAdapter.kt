package com.example.foosball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foosball.R
import com.example.foosball.data.models.Ranking
import com.example.foosball.databinding.RankItemBinding

class RankingAdapter(
    var rankings: List<Ranking>
): RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RankItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).let { RankingViewHolder(it) }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.setRanking(rankings[position])
    }

    override fun getItemCount() = rankings.size

    class RankingViewHolder(
        private val binding: RankItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun setRanking(ranking: Ranking) = with(binding) {
            tvPlayer.text = root.resources.getString(R.string.player_name).format(ranking.player)
            tvGamesWon.text = root.resources.getString(R.string.games_won).format(ranking.gamesWon.toString())
            tvGamesPlayed.text = root.resources.getString(R.string.games_played).format(ranking.gamesPlayed.toString())
        }
    }
}