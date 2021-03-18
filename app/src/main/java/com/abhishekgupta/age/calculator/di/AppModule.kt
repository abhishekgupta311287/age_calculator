package com.abhishekgupta.age.calculator.di

import com.abhishekgupta.age.calculator.repo.AgeRepoImpl
import com.abhishekgupta.age.calculator.repo.IAgeRepo
import com.abhishekgupta.age.calculator.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<IAgeRepo> { AgeRepoImpl() }
    viewModel { MainViewModel(get()) }
}