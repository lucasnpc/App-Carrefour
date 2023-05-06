package com.example.appcarrefour.login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.Primary
import com.example.appcarrefour.ui.theme.PrimaryDark

@Composable
inline fun SecretEditText(userSecret: String, crossinline returnSecret: (String) -> Unit) {
    TextField(
        value = userSecret, onValueChange = {
            returnSecret(it)
        },
        label = { Text(text = stringResource(R.string.secret)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock, contentDescription = stringResource(
                    R.string.person_icon_description
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
        visualTransformation = PasswordVisualTransformation()
    )
}