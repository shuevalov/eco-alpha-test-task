package ru.shuevalov.eco_alpha_test_task.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bins")
data class Bin(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

//    @ColumnInfo(name = "bin") val bin: Int,

//    @ColumnInfo(name = "country") val country: String,

    @ColumnInfo(name = "scheme") val scheme: String,

//    @ColumnInfo(name = "bankUrl") val bankUrl: String,

//    @ColumnInfo(name = "bankNumber") val bankNumber: String,

//    @ColumnInfo(name = "bankCity") val bankCity: String
)