package ru.shuevalov.eco_alpha_test_task.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.binds
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.shuevalov.eco_alpha_test_task.data.repository.AppRepository
import ru.shuevalov.eco_alpha_test_task.data.repository.AppRepositoryImpl
import ru.shuevalov.eco_alpha_test_task.data.api.CloudRepositoryImpl
import ru.shuevalov.eco_alpha_test_task.data.api.CloudRepository

val repositoryModule = module {
    singleOf(::CloudRepositoryImpl) { bind<CloudRepository>() }
    singleOf(::AppRepositoryImpl) { bind<AppRepository>() }
}