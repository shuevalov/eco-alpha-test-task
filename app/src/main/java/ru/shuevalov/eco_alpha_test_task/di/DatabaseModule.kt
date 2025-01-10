package ru.shuevalov.eco_alpha_test_task.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.shuevalov.eco_alpha_test_task.data.database.BinsDatabase

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            BinsDatabase::class.java,
            "bin_database"
        ).fallbackToDestructiveMigration()
            .build()
    }
    single { get<BinsDatabase>().getDao() }
}