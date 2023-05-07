package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.ui.theme.MidGray
import com.example.appcarrefour.ui.theme.PrimaryDark
import com.example.appcarrefour.ui.theme.PrimaryRed

@Composable
inline fun DescriptionTextField(
    description: String,
    error: MutableState<Boolean>,
    crossinline returnDescription: (String) -> Unit
) {
    Text(text = "Descrição", color = Color.Black)
    OutlinedTextField(
        value = description,
        onValueChange = {
            returnDescription(it)
            error.value = false
        },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Descrição") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = PrimaryDark,
            focusedLabelColor = PrimaryDark,
            unfocusedIndicatorColor = PrimaryDark,
            cursorColor = PrimaryDark,
            unfocusedLabelColor = if (error.value) PrimaryRed else MidGray,
            textColor = Color.Black,
            errorIndicatorColor = PrimaryRed,
            errorLabelColor = PrimaryRed,
            errorCursorColor = PrimaryRed,
        ),
        isError = error.value
    )
}