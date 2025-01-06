package ru.shuevalov.eco_alpha_test_task.data.api

import ru.shuevalov.eco_alpha_test_task.data.model.Bin

interface CloudRepository {
    suspend fun getBinById(id: String): Bin
}