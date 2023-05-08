package com.example.appcarrefour.main.presentation.data

import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import java.util.*

class FakeCarrefourRepository(private val list: List<CashRegisterDto>) : CarrefourRepository {
    override suspend fun saveCashRegister(cashRegisterDto: CashRegisterDto) {
        list.toMutableList().add(cashRegisterDto)
    }

    override suspend fun getCashRegisterByDateFilter(
        dateBegin: Date,
        dateEnd: Date
    ): List<CashRegisterDto> {
        return list
    }
}