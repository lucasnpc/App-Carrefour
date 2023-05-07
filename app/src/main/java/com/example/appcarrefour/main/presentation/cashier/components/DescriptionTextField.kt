package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.ui.theme.MidGray
import com.example.appcarrefour.ui.theme.NeutralGray
import com.example.appcarrefour.ui.theme.PrimaryDark

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