package com.example.appcarrefour.main.domain.useCases

import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.utils.toDate

class SaveCashRegisterUsecase(private val carrefourRepository: CarrefourRepository) {
    suspend operator fun invoke(cashRegister: CashRegister) {
        try {
            cashRegister.run {
                carrefourRepository.saveCashRegister(
                    CashRegisterDto(
                        description = description,
                        value = value,
                        date = date.toDate(),
                        type = type
                    )
                )
            }
        } catch (ex: java.lang.Exception) {
            Throwable(ex)
        }
    }
}