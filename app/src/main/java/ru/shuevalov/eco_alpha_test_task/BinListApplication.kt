package ru.shuevalov.eco_alpha_test_task

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.shuevalov.eco_alpha_test_task.di.apiModule
import ru.shuevalov.eco_alpha_test_task.di.databaseModule
import ru.shuevalov.eco_alpha_test_task.di.repositoryModule
import ru.shuevalov.eco_alpha_test_task.di.viewModelModule

class BinListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BinListApplication)
            modules(apiModule, databaseModule, repositoryModule, viewModelModule)
        }
    }
}