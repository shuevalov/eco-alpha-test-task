package ru.shuevalov.eco_alpha_test_task.data.repository

import kotlinx.coroutines.flow.Flow
import ru.shuevalov.eco_alpha_test_task.data.api.CloudRepository
import ru.shuevalov.eco_alpha_test_task.data.database.BinDao
import ru.shuevalov.eco_alpha_test_task.data.model.Bin

class AppRepositoryImpl(
    private val binDao: BinDao,
    private val cloud: CloudRepository
) : AppRepository {
    override fun getAllBins(): Flow<List<Bin>> = binDao.getAllBins()

    override suspend fun insert(bin: Bin) = binDao.insertBin(bin)

    override suspend fun delete(bin: Bin) = binDao.deleteBin(bin)

    override suspend fun getBinById(id: String): Bin = cloud.getBinById(id)
}