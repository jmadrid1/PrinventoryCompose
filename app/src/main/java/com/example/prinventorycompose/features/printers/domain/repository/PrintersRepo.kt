package com.example.prinventorycompose.features.printers.domain.repository

import com.example.prinventorycompose.features.printers.domain.model.Printer
import kotlinx.coroutines.flow.Flow

interface PrintersRepo {

    fun getPrinters(): Flow<List<Printer>>

    suspend fun addPrinter(printer: Printer)

    suspend fun deletePrinter(printer: Printer)

}