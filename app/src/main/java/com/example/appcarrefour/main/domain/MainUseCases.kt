package com.example.appcarrefour.main.domain

import com.example.appcarrefour.main.domain.useCases.GetCashRegisterByDateUsecase
import com.example.appcarrefour.main.domain.useCases.SaveCashRegisterUsecase

data class MainUseCases(
    val getCashRegisterByDateUsecase: GetCashRegisterByDateUsecase,
    val saveCashRegisterUsecase: SaveCashRegisterUsecase
)