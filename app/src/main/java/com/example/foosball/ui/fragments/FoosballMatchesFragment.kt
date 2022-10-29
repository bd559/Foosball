package com.example.foosball.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foosball.R
import com.example.foosball.adapter.FoosballMatchAdapter
import com.example.foosball.data.models.FoosballMatch
import com.example.foosball.databinding.FoosballMatchesFragmentBinding
import com.example.foosball.ui.foosballmatch.AddDialogListener
import com.example.foosball.ui.foosballmatch.AddFoosballMatchDialog
import com.example.foosball.ui.viewmodels.FoosballViewModel
import com.example.foosball.utils.getRankings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoosballMatchesFragment : Fragment(R.layout.foosball_matches_fragment) {

    private val viewModel: FoosballViewModel by viewModels()
    private lateinit var binding: FoosballMatchesFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FoosballMatchAdapter(listOf(), viewModel, { viewModel::upsert })
        binding = FoosballMatchesFragmentBinding.bind(view).apply {
            btnRankings.setOnClickListener {
                findNavController().navigate(FoosballMatchesFragmentDirections.actionFoosballMatchesFragmentToRankingFragment(
                    viewModel.allFoosballMatches.value?.getRankings()?.toTypedArray()
                ))
            }
            rvFoosballMatchItems.layoutManager = LinearLayoutManager(context)
            rvFoosballMatchItems.adapter = adapter
            viewModel.allFoosballMatches.observe(viewLifecycleOwner) {
                adapter.matches = it
                adapter.notifyDataSetChanged()
            }
            fab.setOnClickListener {
                AddFoosballMatchDialog(requireContext(),
                object : AddDialogListener {
                    override fun onAddButtonClicked(match: FoosballMatch) {
                        viewModel.upsert(match)
                    }
                }, null).show()
            }
        }
    }
}