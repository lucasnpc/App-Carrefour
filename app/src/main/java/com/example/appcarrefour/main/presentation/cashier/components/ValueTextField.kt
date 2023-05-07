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
import com.example.appcarrefour.ui.theme.MidGray
import com.example.appcarrefour.ui.theme.PrimaryDark

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
            backgroundColor = Color.White,
            focusedIndicatorColor = PrimaryDark,
            focusedLabelColor = PrimaryDark,
            unfocusedIndicatorColor = PrimaryDark,
            cursorColor = PrimaryDark,
            unfocusedLabelColor = MidGray,
            textColor = Color.Black
        )
    )
}