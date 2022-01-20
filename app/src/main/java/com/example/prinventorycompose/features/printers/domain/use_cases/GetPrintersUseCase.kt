package com.example.prinventorycompose.features.printers.domain.use_cases

import com.example.prinventorycompose.features.printers.data.local.PrinterDAO
import javax.inject.Inject

class GetPrintersUseCase @Inject constructor(private val printerDao: PrinterDAO) {

    suspend operator fun invoke() = printerDao.getPrinters()

}