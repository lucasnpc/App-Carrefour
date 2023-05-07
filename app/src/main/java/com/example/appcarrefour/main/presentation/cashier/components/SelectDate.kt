package com.example.appcarrefour.main.presentation.cashier.components

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.PrimaryVariant

@Composable
fun SelectDate(date: MutableState<String>, datePickerDialog: DatePickerDialog) {
    Column {
        Text(text = stringResource(id = R.string.select_date, date.value), color = Color.Black)
        OutlinedButton(onClick = {
            datePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryVariant)) {
            Text(text = stringResource(R.string.open_calendary), color = Color.White)
        }
    }
}
