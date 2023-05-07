package com.example.appcarrefour.domain.data

import com.example.appcarrefour.data.dto.CashRegisterDto
import java.util.*

interface CarrefourRepository {
    suspend fun saveCashRegister(cashRegisterDto: CashRegisterDto)
    suspend fun getCashRegisterByDateFilter(
        dateBegin: Date,
        dateEnd: Date
    ): List<CashRegisterDto>
}