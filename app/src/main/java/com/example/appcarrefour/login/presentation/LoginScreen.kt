package com.example.appcarrefour.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcarrefour.login.presentation.components.CarrefourIcon
import com.example.appcarrefour.login.presentation.components.EmailEditText
import com.example.appcarrefour.login.presentation.components.LoginButton
import com.example.appcarrefour.login.presentation.components.SecretEditText

@Composable
@Preview
fun LoginScreen() {
    var userEmail by remember { mutableStateOf("") }
    var userSecret by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 130.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CarrefourIcon()
        Spacer(modifier = Modifier.height(180.dp))
        EmailEditText(userEmail) {
            userEmail = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        SecretEditText(userSecret) {
            userSecret = it
        }
        Spacer(modifier = Modifier.height(30.dp))
        LoginButton()
    }
}