package ru.shuevalov.eco_alpha_test_task.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    val name: String? = null,
    val url: String? = null,
    val phone: String? = null,
    val city: String? = null,
)