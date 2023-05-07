package com.example.appcarrefour.domain.data

import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.main.domain.model.CashRegister
import java.util.*

interface CarrefourRepository {
    suspend fun saveCashRegister(cashRegisterDto: CashRegisterDto)
    suspend fun getCashRegisterByDateFilter(
        dateBegin: Date,
        dateEnd: Date
    ): List<CashRegisterDto>
}