package ru.shuevalov.eco_alpha_test_task.data.model.converters

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import ru.shuevalov.eco_alpha_test_task.data.model.Bank


class BankConverter {

    @TypeConverter
    fun convertToJsonString(obj: Bank?): String {
        return Json.encodeToString(obj)
    }

    @TypeConverter
    fun convertToObject(json: String): Bank? {
        return Json.decodeFromString(json)
    }
}