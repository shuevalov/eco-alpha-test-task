package ru.shuevalov.eco_alpha_test_task.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.serialization.Serializable
import ru.shuevalov.eco_alpha_test_task.data.model.converters.BankConverter
import ru.shuevalov.eco_alpha_test_task.data.model.converters.CountryConverter

@Serializable
@Entity(tableName = "bins")
data class Bin(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "bin")
    val bin: String? = null,

    @ColumnInfo(name = "scheme")
    val scheme: String? = null,

    @ColumnInfo(name = "country")
    @TypeConverters(CountryConverter::class)
    val country: Country? = null,

    @ColumnInfo(name = "bank")
    @TypeConverters(BankConverter::class)
    val bank: Bank? = null
)