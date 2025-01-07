package ru.shuevalov.eco_alpha_test_task.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.shuevalov.eco_alpha_test_task.ui.screens.home.HomeViewModel
import ru.shuevalov.eco_alpha_test_task.ui.screens.bins.BinsViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::BinsViewModel)
}