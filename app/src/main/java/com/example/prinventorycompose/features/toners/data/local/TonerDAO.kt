package com.example.prinventorycompose.features.toners.data.local

import androidx.room.*
import com.example.prinventorycompose.features.toners.domain.model.Toner
import kotlinx.coroutines.flow.Flow

@Dao
interface TonerDAO {

    companion object {
        const val TABLE_TONER = "toners"
    }

    @Query("SELECT * FROM $TABLE_TONER")
    fun getToners(): Flow<List<Toner>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToner(toner: Toner)

    @Delete
    suspend fun deleteToner(toner: Toner)

}