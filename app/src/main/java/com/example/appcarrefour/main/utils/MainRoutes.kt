package com.example.appcarrefour.main.utils

sealed class MainRoutes(val route: String){
    object MainScreen: MainRoutes("main_screen")
    object CashierScreen: MainRoutes("cashier_screen")
    object ReportScreen: MainRoutes("report_screen")
}
