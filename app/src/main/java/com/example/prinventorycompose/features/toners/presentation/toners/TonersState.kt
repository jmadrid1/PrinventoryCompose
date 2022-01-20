package com.example.prinventorycompose.features.toners.presentation.toners

import com.example.prinventorycompose.features.toners.domain.model.Toner

data class TonersState(
    val toners: List<Toner> = emptyList()
)