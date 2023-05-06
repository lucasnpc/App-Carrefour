package com.example.appcarrefour.main.presentation.cashier.components

import android.app.DatePickerDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.ui.theme.Primary

@Composable
fun SelectDate(date: MutableState<String>, datePickerDialog: DatePickerDialog) {
    Text(text = "Selecionar data: ${date.value}", color = Color.Black)

    OutlinedButton(onClick = {
        datePickerDialog.show()
    }, colors = ButtonDefaults.buttonColors(backgroundColor = Primary)) {
        Text(text = "Abrir calendário", color = Color.White)
    }
}