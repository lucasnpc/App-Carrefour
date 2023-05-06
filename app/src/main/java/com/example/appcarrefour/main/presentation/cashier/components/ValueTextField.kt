package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
inline fun ValueTextField(value: String, crossinline returnValue: (String) -> Unit) {
    Text(text = "Valor", color = Color.Black)
    OutlinedTextField(
        value = value,
        onValueChange = {
            returnValue(it)
        },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Valor")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White
        )
    )
}