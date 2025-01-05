package ru.shuevalov.eco_alpha_test_task.data.repository

import kotlinx.coroutines.flow.Flow
import ru.shuevalov.eco_alpha_test_task.data.model.Bin

interface BinsRepository {
    fun getAllBins(): Flow<List<Bin>>

    suspend fun insert(bin: Bin)

    suspend fun update(bin: Bin)

    suspend fun delete(bin: Bin)
}