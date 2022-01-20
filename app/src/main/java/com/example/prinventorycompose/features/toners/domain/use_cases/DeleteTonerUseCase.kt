package com.example.prinventorycompose.features.toners.domain.use_cases

import com.example.prinventorycompose.features.toners.data.local.TonerDAO
import com.example.prinventorycompose.features.toners.domain.model.Toner
import javax.inject.Inject

class DeleteTonerUseCase @Inject constructor(private val tonerDAO: TonerDAO) {

    suspend operator fun invoke(toner: Toner) = tonerDAO.deleteToner(toner)

}