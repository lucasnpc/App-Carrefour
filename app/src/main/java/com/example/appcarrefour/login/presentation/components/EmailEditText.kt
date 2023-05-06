package com.example.appcarrefour.login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.Primary
import com.example.appcarrefour.ui.theme.PrimaryDark

@Composable
inline fun EmailEditText(userEmail: String, crossinline returnEmail: (String) -> Unit) {
    TextField(
        value = userEmail, onValueChange = {
            returnEmail(it)
        },
        label = { Text(text = stringResource(R.string.email)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Person, contentDescription = stringResource(
                    R.string.user_icon_description
                ), tint = Primary
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = PrimaryDark,
            focusedLabelColor = PrimaryDark,
            unfocusedIndicatorColor = PrimaryDark
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}