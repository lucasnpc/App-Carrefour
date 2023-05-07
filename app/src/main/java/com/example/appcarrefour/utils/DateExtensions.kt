package com.example.appcarrefour.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToBrazilian(): String =
    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this)