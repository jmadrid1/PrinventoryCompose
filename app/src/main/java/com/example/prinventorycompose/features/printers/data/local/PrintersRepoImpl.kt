package com.example.prinventorycompose.features.printers.data.local

import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.features.printers.domain.repository.PrintersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrintersRepoImpl @Inject constructor(private val printerDao: PrinterDAO) : PrintersRepo {

    override fun getPrinters(): Flow<List<Printer>> {
        return printerDao.getPrinters()
    }

    override suspend fun addPrinter(printer: Printer) {
        printerDao.addPrinter(printer)
    }

    override suspend fun deletePrinter(printer: Printer) {
        printerDao.deletePrinter(printer)
    }

}