package com.example.prinventorycompose.di

import android.content.Context
import androidx.room.Room
import com.example.prinventorycompose.features.printers.data.local.PrinterDAO
import com.example.prinventorycompose.features.printers.data.local.PrinventoryDatabase
import com.example.prinventorycompose.features.printers.domain.use_cases.AddPrinterUseCase
import com.example.prinventorycompose.features.printers.domain.use_cases.DeletePrinterUseCase
import com.example.prinventorycompose.features.printers.domain.use_cases.GetPrintersUseCase
import com.example.prinventorycompose.features.toners.data.local.TonerDAO
import com.example.prinventorycompose.features.toners.domain.use_cases.AddTonerUseCase
import com.example.prinventorycompose.features.toners.domain.use_cases.DeleteTonerUseCase
import com.example.prinventorycompose.features.toners.domain.use_cases.GetTonersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        PrinventoryDatabase::class.java,
        "prinventory_db")
        .build()

    @Singleton
    @Provides
    fun providePrinterDao(db: PrinventoryDatabase) = db.printerDao()

    @Provides
    @Singleton
    fun provideGetPrintersUseCase(printerDao: PrinterDAO): GetPrintersUseCase {
        return GetPrintersUseCase(printerDao)
    }

    @Provides
    @Singleton
    fun provideAddPrinterUseCase(printerDao: PrinterDAO): AddPrinterUseCase {
        return AddPrinterUseCase(printerDao)
    }

    @Provides
    @Singleton
    fun provideDeletePrinterUseCase(printerDao: PrinterDAO): DeletePrinterUseCase {
        return DeletePrinterUseCase(printerDao)
    }

    @Singleton
    @Provides
    fun provideTonerDao(db: PrinventoryDatabase) = db.tonerDao()

    @Provides
    @Singleton
    fun provideGetTonersUseCase(tonerDao: TonerDAO): GetTonersUseCase {
        return GetTonersUseCase(tonerDao)
    }

    @Provides
    @Singleton
    fun provideAddTonerUseCase(tonerDao: TonerDAO): AddTonerUseCase {
        return AddTonerUseCase(tonerDao)
    }

    @Provides
    @Singleton
    fun provideDeleteTonerUseCase(tonerDao: TonerDAO): DeleteTonerUseCase {
        return DeleteTonerUseCase(tonerDao)
    }

}