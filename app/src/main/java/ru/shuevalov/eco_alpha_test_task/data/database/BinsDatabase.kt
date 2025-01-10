package ru.shuevalov.eco_alpha_test_task.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shuevalov.eco_alpha_test_task.data.model.converters.BankConverter
import ru.shuevalov.eco_alpha_test_task.data.model.Bin
import ru.shuevalov.eco_alpha_test_task.data.model.converters.CountryConverter

const val DATABASE_VERSION_CODE = 4

@TypeConverters(CountryConverter::class, BankConverter::class)
@Database(entities = [Bin::class], version = DATABASE_VERSION_CODE, exportSchema = false)
abstract class BinsDatabase : RoomDatabase() {
    abstract fun getDao(): BinDao
}