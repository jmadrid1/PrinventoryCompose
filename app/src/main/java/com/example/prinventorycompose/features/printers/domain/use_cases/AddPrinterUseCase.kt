package com.example.prinventorycompose.features.printers.domain.use_cases

import com.example.prinventorycompose.features.printers.data.local.PrinterDAO
import com.example.prinventorycompose.features.printers.domain.model.Printer
import javax.inject.Inject

class AddPrinterUseCase @Inject constructor(private val printerDao: PrinterDAO) {

    suspend operator fun invoke(printer: Printer) = printerDao.addPrinter(printer)

}