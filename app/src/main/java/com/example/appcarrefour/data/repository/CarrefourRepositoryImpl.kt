package com.example.appcarrefour.data.repository

import com.example.appcarrefour.data.dao.CarrefourDao
import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import java.util.*


class CarrefourRepositoryImpl(private val carrefourDao: CarrefourDao) : CarrefourRepository {
    override suspend fun saveCashRegister(cashRegisterDto: CashRegisterDto) {
        carrefourDao.saveCashRegister(
            cashRegisterDto
        )
    }

    override suspend fun getCashRegisterByDateFilter(
        dateBegin: Date,
        dateEnd: Date
    ): List<CashRegisterDto> {
        return carrefourDao.getCashRegisterByDateFilter(dateBegin, dateEnd)
    }
}