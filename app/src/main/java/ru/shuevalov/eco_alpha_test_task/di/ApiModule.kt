package ru.shuevalov.eco_alpha_test_task.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.shuevalov.eco_alpha_test_task.data.api.ApiService

val BASE_URL = "https://binlist.net/"

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()

fun provideRetrofit(): Retrofit =
    Retrofit
        .Builder()
        .addConverterFactory(provideConverterFactory())
        .baseUrl(BASE_URL)
        .build()

fun provideService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

val apiModule = module {
    single { provideRetrofit() }
    single { provideService(get()) }
}