package com.example.prinventorycompose.features.toners.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "toners")
data class Toner(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "make")
    var make: String?,
    @ColumnInfo(name = "model")
    var model: String?,
    @ColumnInfo(name = "tonerModel")
    var tonerModel: String?,
    @ColumnInfo(name = "black")
    var black: Int?,
    @ColumnInfo(name = "cyan")
    var cyan: Int?,
    @ColumnInfo(name = "yellow")
    var yellow: Int?,
    @ColumnInfo(name = "magenta")
    var magenta: Int?) : Serializable