package ru.shuevalov.eco_alpha_test_task.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null,
)