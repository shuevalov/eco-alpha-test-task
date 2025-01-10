package ru.shuevalov.eco_alpha_test_task.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.shuevalov.eco_alpha_test_task.data.model.Bin

@Dao
interface BinDao {
    @Query("SELECT * FROM bins ORDER BY id DESC")
    fun getAllBins(): Flow<List<Bin>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBin(bin: Bin)

    @Delete
    suspend fun deleteBin(bin: Bin)
}