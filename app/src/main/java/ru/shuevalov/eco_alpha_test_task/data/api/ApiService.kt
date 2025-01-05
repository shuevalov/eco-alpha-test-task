package ru.shuevalov.eco_alpha_test_task.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.shuevalov.eco_alpha_test_task.data.model.Bin

interface ApiService {
    @GET("{id}")
    suspend fun getBinById(@Path("id") binId: Int): Bin
}