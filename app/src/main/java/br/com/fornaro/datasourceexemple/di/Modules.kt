package br.com.fornaro.datasourceexemple.di

import android.content.Context
import br.com.fornaro.datasourceexemple.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel { MainViewModel(sharedPrefs = get()) }
}

private val dataSourceModule = module {
    single { androidApplication().getSharedPreferences("settings", Context.MODE_PRIVATE) }
}

val allModules = viewModelModule + dataSourceModule