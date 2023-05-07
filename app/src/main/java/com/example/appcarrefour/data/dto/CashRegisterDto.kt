package com.example.appcarrefour.data.dto

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "cash_registers")
data class CashRegisterDto(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "register_description")
    val description: String,
    @ColumnInfo(name = "register_value")
    val value: Double,
    @ColumnInfo(name = "register_date")
    val date: Date,
    @ColumnInfo(name = "register_type")
    val type: String
) : Parcelable

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
