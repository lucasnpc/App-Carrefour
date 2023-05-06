package com.example.appcarrefour.login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.PrimaryDark

@Composable
inline fun LoginButton(crossinline loginClick: () -> Unit) {
    Button(
        onClick = { loginClick() },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDark)
    ) {
        Text(text = stringResource(R.string.login_text), fontSize = 16.sp, color = Color.White)
    }
}