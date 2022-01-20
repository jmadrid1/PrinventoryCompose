package com.example.prinventorycompose.features.printers.presentation.printers

import com.example.prinventorycompose.features.printers.domain.model.Printer

data class PrintersState(
    val printers: List<Printer> = emptyList(),
)