package ru.shuevalov.eco_alpha_test_task.data.api

import ru.shuevalov.eco_alpha_test_task.data.model.Bin

class CloudRepositoryImpl(private val api: ApiService) : CloudRepository {
    override suspend fun getBinFromHttp(id: String): Bin {
        return try {
            api.getBinById(id)
        } catch(e: Exception) { // http 429 temporary handling
            Bin(scheme = "error")
        }
    }
}