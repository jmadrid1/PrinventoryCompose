package com.example.prinventorycompose.features.printers.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "printers")
data class Printer(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "make")
    var make: String?,
    @ColumnInfo(name = "model")
    var model: String?,
    @ColumnInfo(name = "serial")
    var serial: String?,
    @ColumnInfo(name = "owner")
    var owner: String?,
    @ColumnInfo(name = "department")
    var dept: String?,
    @ColumnInfo(name = "location")
    var location: String?,
    @ColumnInfo(name = "floor")
    var floor: String?,
    @ColumnInfo(name = "ip")
    var ip: String?) : Parcelable