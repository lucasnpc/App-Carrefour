package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
inline fun DescriptionTextField(
    description: String,
    crossinline returnDescription: (String) -> Unit
) {
    Text(text = "Descrição", color = Color.Black)
    OutlinedTextField(
        value = description,
        onValueChange = {
            returnDescription(it)
        },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Descrição") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White
        )
    )
}