package com.example.foosball.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foosball.R
import com.example.foosball.adapter.RankingAdapter
import com.example.foosball.databinding.FoosballRankingFragmentBinding
import com.example.foosball.ui.viewmodels.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : Fragment(R.layout.foosball_ranking_fragment) {

    private val viewModel: RankingViewModel by viewModels()
    private val arguments by navArgs<RankingFragmentArgs>()
    private lateinit var binding: FoosballRankingFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RankingAdapter(listOf())
        arguments.rankings?.let {
            viewModel.getRankings(it.toList())
        }
        binding = FoosballRankingFragmentBinding.bind(view).apply {
            rvRankings.layoutManager = LinearLayoutManager(context)
            rvRankings.adapter = adapter
            viewModel.rankings.observe(this@RankingFragment.viewLifecycleOwner) {
                rvRankings.layoutManager = LinearLayoutManager(context)
                adapter.rankings = it
                adapter.notifyDataSetChanged()
            }
            btnAllMatches.setOnClickListener {
                findNavController().navigate(RankingFragmentDirections.actionRankingFragmentToFoosballMatchesFragment())
            }

            btnOrderByGames.setOnClickListener {
                viewModel.sortByGamePlayed()
            }

            btnOrderByWins.setOnClickListener {
                viewModel.sortByGameWon()
            }
        }
    }
}