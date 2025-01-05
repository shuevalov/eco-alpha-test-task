package ru.shuevalov.eco_alpha_test_task.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.shuevalov.eco_alpha_test_task.data.repository.BinsRepository
import ru.shuevalov.eco_alpha_test_task.data.repository.BinsRepositoryImpl

val repositoryModule = module {
    singleOf(::BinsRepositoryImpl) { bind<BinsRepository>() }
}