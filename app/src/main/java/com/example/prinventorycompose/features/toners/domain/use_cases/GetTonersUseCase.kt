package com.example.prinventorycompose.features.toners.domain.use_cases

import com.example.prinventorycompose.features.toners.data.local.TonerDAO
import javax.inject.Inject

class GetTonersUseCase @Inject constructor(private val tonerDAO: TonerDAO) {

    suspend operator fun invoke() = tonerDAO.getToners()

}