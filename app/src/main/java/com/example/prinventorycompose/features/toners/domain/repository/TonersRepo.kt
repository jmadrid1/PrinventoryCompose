package com.example.prinventorycompose.features.toners.domain.repository

import com.example.prinventorycompose.features.toners.domain.model.Toner
import kotlinx.coroutines.flow.Flow

interface TonersRepo {

    fun getToners(): Flow<List<Toner>>

    suspend fun addToner(toner: Toner)

    suspend fun deleteToner(toner: Toner)

}