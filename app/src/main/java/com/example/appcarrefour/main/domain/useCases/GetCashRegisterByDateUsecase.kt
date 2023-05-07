package com.example.appcarrefour.main.domain.useCases

import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.utils.toDate

class GetCashRegisterByDateUsecase(private val carrefourRepository: CarrefourRepository) {
    suspend operator fun invoke(dateBegin: String, dateEnd: String) {
        try {
            carrefourRepository.getCashRegisterByDateFilter(dateBegin.toDate(), dateEnd.toDate())
        } catch (ex: Exception) {
            Throwable(ex)
        }
    }
}