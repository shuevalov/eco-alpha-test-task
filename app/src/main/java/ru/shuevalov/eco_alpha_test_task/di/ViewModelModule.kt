package ru.shuevalov.eco_alpha_test_task.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.shuevalov.eco_alpha_test_task.ui.screens.home.HomeViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}