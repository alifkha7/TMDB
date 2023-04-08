package com.hirocode.tmdb

import android.app.Application
import com.hirocode.tmdb.di.networkModule
import com.hirocode.tmdb.di.repositoryModule
import com.hirocode.tmdb.di.useCaseModule
import com.hirocode.tmdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}