package com.example.appcarrefour.ui.commons

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.runtime.MutableState
import com.example.appcarrefour.utils.toBrazilianDateFormat
import java.time.LocalDate
import java.util.*

fun carrefourDatePickDialog(
    context: Context,
    date: MutableState<String>,
    selectedDate: (String) -> Unit = {}
): DatePickerDialog {
    val calendar = Calendar.getInstance()
    calendar.time = Date()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    return DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date.value =
                java.sql.Date.valueOf(LocalDate.of(mYear, mMonth + 1, mDayOfMonth).toString())
                    .toBrazilianDateFormat()
            selectedDate(date.value)
        }, year, month, day
    )
}