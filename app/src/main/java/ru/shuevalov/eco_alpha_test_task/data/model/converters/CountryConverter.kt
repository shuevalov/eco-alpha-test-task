package ru.shuevalov.eco_alpha_test_task.data.model.converters

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import ru.shuevalov.eco_alpha_test_task.data.model.Country


class CountryConverter {

    @TypeConverter
    fun convertToJsonString(obj: Country?): String {
        return Json.encodeToString(obj)
    }

    @TypeConverter
    fun convertToObject(json: String): Country? {
        return Json.decodeFromString(json)
    }
}