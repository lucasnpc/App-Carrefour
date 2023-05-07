package com.example.appcarrefour.main.domain.useCases

import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.utils.Result
import com.example.appcarrefour.utils.toDate

class SaveCashRegisterUsecase(private val carrefourRepository: CarrefourRepository) {
    suspend operator fun invoke(cashRegister: CashRegister): Result<Boolean> {
        return try {
            cashRegister.run {
                carrefourRepository.saveCashRegister(
                    CashRegisterDto(
                        description = description,
                        value = value.toDouble(),
                        date = date.toDate(),
                        type = type
                    )
                )
                Result.Success(true)
            }
        } catch (ex: java.lang.Exception) {
            Result.Error(ex.message)
        }
    }
}