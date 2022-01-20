package com.example.prinventorycompose.features.toners.data.local


import com.example.prinventorycompose.features.toners.domain.model.Toner
import com.example.prinventorycompose.features.toners.domain.repository.TonersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TonersRepoImpl @Inject constructor(private val tonerDAO: TonerDAO) : TonersRepo {

    override fun getToners(): Flow<List<Toner>> {
        return tonerDAO.getToners()
    }

    override suspend fun addToner(toner: Toner) {
        tonerDAO.addToner(toner)
    }

    override suspend fun deleteToner(toner: Toner) {
        tonerDAO.deleteToner(toner)
    }

}