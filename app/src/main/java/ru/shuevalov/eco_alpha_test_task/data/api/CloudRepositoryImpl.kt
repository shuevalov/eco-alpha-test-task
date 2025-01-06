package ru.shuevalov.eco_alpha_test_task.data.api

import ru.shuevalov.eco_alpha_test_task.data.model.Bin

class CloudRepositoryImpl(val api: ApiService) : CloudRepository {
    override suspend fun getBinById(id: String): Bin {
        return api.getBinById(id)
    }
}