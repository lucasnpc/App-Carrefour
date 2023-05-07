package com.example.appcarrefour.main.di

import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.domain.MainUseCases
import com.example.appcarrefour.main.domain.useCases.GetCashRegisterByDateUsecase
import com.example.appcarrefour.main.domain.useCases.SaveCashRegisterUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {
    @Provides
    @ViewModelScoped
    fun provideMainUsecases(carrefourRepository: CarrefourRepository): MainUseCases =
        MainUseCases(
            getCashRegisterByDateUsecase = GetCashRegisterByDateUsecase(carrefourRepository),
            saveCashRegisterUsecase = SaveCashRegisterUsecase(carrefourRepository)
        )
}