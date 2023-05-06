package com.example.appcarrefour.login.presentation

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcarrefour.login.presentation.components.AlternativeLoginMethodsButtons
import com.example.appcarrefour.login.presentation.components.EmailEditText
import com.example.appcarrefour.login.presentation.components.LoginButton
import com.example.appcarrefour.login.presentation.components.SecretEditText
import com.example.appcarrefour.main.MainActivity
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.utils.*

@Composable
@Preview
fun LoginScreen() {
    var userEmail by remember { mutableStateOf("") }
    var userSecret by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimen80dp, start = Dimen24dp, end = Dimen24dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CarrefourIcon()
        Spacer(modifier = Modifier.height(Dimen80dp))
        EmailEditText(userEmail) {
            userEmail = it
        }
        Spacer(modifier = Modifier.height(Dimen10dp))
        SecretEditText(userSecret) {
            userSecret = it
        }
        Spacer(modifier = Modifier.height(Dimen30dp))
        LoginButton {
            context.run {
                startActivity(Intent(context, MainActivity::class.java))
                (this as Activity).finish()
            }
        }
        Spacer(modifier = Modifier.height(Dimen20dp))
        AlternativeLoginMethodsButtons()
    }
}