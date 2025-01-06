package ru.shuevalov.eco_alpha_test_task.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.shuevalov.eco_alpha_test_task.data.api.ApiService

const val BASE_URL = "https://lookup.binlist.net/"
val gson = GsonBuilder().setLenient().create()!!

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create(gson)

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