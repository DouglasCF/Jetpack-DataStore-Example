package br.com.fornaro.datasourceexemple

import android.app.Application
import br.com.fornaro.datasourceexemple.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(allModules)
        }
    }
}