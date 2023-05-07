package com.example.appcarrefour.main.presentation.cashier.components

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.ui.theme.PrimaryVariant

@Composable
fun SelectDate(date: MutableState<String>, datePickerDialog: DatePickerDialog) {
    Column {
        Text(text = "Selecionar data: ${date.value}", color = Color.Black)
        OutlinedButton(onClick = {
            datePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryVariant)) {
            Text(text = "Abrir calendário", color = Color.White)
        }
    }

}