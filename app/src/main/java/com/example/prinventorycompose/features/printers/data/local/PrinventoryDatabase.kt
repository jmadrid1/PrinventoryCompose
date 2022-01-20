package com.example.prinventorycompose.features.printers.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.features.toners.data.local.TonerDAO
import com.example.prinventorycompose.features.toners.domain.model.Toner

@Database(entities = [Printer::class,
                    Toner::class],
                    version = 1,
                    exportSchema = false)
abstract class PrinventoryDatabase : RoomDatabase() {

    abstract fun printerDao(): PrinterDAO

    abstract fun tonerDao(): TonerDAO

}