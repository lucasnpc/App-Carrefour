package com.example.appcarrefour.main.domain.useCases

import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.utils.Result
import com.example.appcarrefour.utils.toBrazilianDateFormat
import com.example.appcarrefour.utils.toDate

class GetCashRegisterByDateUsecase(private val carrefourRepository: CarrefourRepository) {
    suspend operator fun invoke(dateBegin: String, dateEnd: String): Result<List<CashRegister>> {
        return try {
            val registers = carrefourRepository.getCashRegisterByDateFilter(
                dateBegin.toDate(),
                dateEnd.toDate()
            ).map {
                CashRegister(
                    it.description,
                    it.value.toString(),
                    it.date.toBrazilianDateFormat(),
                    it.type
                )
            }
            Result.Success(registers)
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}