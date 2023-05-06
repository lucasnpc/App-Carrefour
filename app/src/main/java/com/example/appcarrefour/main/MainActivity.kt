package com.example.appcarrefour.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcarrefour.main.presentation.main.MainScreen
import com.example.appcarrefour.main.presentation.cashier.CashierScreen
import com.example.appcarrefour.main.presentation.report.ReportScreen
import com.example.appcarrefour.main.utils.MainRoutes
import com.example.appcarrefour.ui.theme.AppCarrefourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppCarrefourTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primaryVariant
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = MainRoutes.MainScreen.route
                    ) {
                        composable(route = MainRoutes.MainScreen.route) {
                            MainScreen(navController)
                        }
                        composable(route = MainRoutes.CashierScreen.route) {
                            CashierScreen()
                        }
                        composable(route = MainRoutes.ReportScreen.route) {
                            ReportScreen()
                        }
                    }
                }
            }
        }
    }
}
