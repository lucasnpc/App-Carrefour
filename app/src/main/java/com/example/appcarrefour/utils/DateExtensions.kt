package com.example.appcarrefour.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toBrazilianDateFormat(): String =
    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this)

fun String.toDate(): Date {
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return format.parse(this) ?: Date()
}