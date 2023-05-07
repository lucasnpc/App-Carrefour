package com.example.appcarrefour.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appcarrefour.data.dto.CashRegisterDto
import java.util.*

@Dao
interface CarrefourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCashRegister(cashRegisterDto: CashRegisterDto)

    @Query("SELECT * FROM cash_registers WHERE register_date >= :dateBegin AND register_date <= :dateEnd")
    suspend fun getCashRegisterByDateFilter(dateBegin: Date, dateEnd: Date): List<CashRegisterDto>
}