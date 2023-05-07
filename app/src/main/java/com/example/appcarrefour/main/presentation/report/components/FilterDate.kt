package com.example.appcarrefour.main.presentation.report.components

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.main.presentation.cashier.components.SelectDate
import com.example.appcarrefour.utils.formatToBrazilian
import java.util.*

@Composable
fun FilterDate(date: MutableState<String>, datePickerDialog: DatePickerDialog) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SelectDate(date, datePickerDialog)
        Text(text = "Hoje: ${Date().formatToBrazilian()}", color = Color.Black)
    }
}