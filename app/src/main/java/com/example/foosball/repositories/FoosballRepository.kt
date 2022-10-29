package com.example.foosball.repositories

import com.example.foosball.data.db.FoosballDao
import com.example.foosball.data.models.FoosballMatch
import javax.inject.Inject

class FoosballRepository @Inject constructor(
    private val foosballDao: FoosballDao,
) {
    suspend fun upsert(match: FoosballMatch) = foosballDao.upsert(match)

    suspend fun delete(match: FoosballMatch) = foosballDao.delete(match)

    fun getAllFoosballMatches() = foosballDao.getAllFoosballMatches()
}

//object FoosballRepository {
//    suspend fun upsert(match: FoosballMatch) {
//        foosballDa
//    }
//}