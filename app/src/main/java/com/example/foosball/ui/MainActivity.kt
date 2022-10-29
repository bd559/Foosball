package com.example.foosball.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.foosball.R
import com.example.foosball.data.db.FoosballDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @Inject
    lateinit var foosballDao: FoosballDao
}