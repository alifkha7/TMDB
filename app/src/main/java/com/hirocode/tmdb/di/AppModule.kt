package com.hirocode.tmdb.di

import com.hirocode.tmdb.MainViewModel
import com.hirocode.tmdb.data.repository.MoviesRepositoryImpl
import com.hirocode.tmdb.data.source.MoviesDataSource
import com.hirocode.tmdb.data.source.MoviesDataSourceImpl
import com.hirocode.tmdb.data.source.service.MoviesService
import com.hirocode.tmdb.domain.repository.MoviesRepository
import com.hirocode.tmdb.domain.usecase.GetPopularUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(MoviesService::class.java)
    }
}

val repositoryModule = module {
    single<MoviesDataSource> { MoviesDataSourceImpl(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory { GetPopularUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}