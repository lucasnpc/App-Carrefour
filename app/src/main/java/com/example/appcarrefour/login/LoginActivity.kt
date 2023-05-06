package com.example.appcarrefour.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appcarrefour.login.presentation.LoginScreen
import com.example.appcarrefour.ui.theme.AppCarrefourTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCarrefourTheme {
                LoginScreen()
            }
        }
    }
}