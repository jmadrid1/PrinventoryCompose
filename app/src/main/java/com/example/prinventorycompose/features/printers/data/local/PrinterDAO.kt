package com.example.prinventorycompose.features.printers.data.local

import androidx.room.*
import com.example.prinventorycompose.features.printers.domain.model.Printer
import kotlinx.coroutines.flow.Flow

@Dao
interface PrinterDAO {

    companion object {
        const val TABLE_PRINTER = "printers"
    }

    @Query("SELECT * FROM $TABLE_PRINTER")
    fun getPrinters(): Flow<List<Printer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPrinter(printer: Printer)

    @Delete
    suspend fun deletePrinter(printer: Printer)

}