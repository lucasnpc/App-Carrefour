package com.example.appcarrefour.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appcarrefour.data.dao.CarrefourDao
import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.data.dto.Converters

@Database(entities = [CashRegisterDto::class], version = 1)
@TypeConverters(Converters::class)
abstract class CarrefourDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "carrefour_db"
    }

    abstract fun carrefourDao(): CarrefourDao
}