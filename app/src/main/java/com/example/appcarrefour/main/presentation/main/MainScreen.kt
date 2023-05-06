package com.example.appcarrefour.main.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appcarrefour.main.presentation.main.components.ButtonCashier
import com.example.appcarrefour.main.presentation.main.components.ButtonReports
import com.example.appcarrefour.main.presentation.main.components.MainHeader
import com.example.appcarrefour.ui.commons.CarrefourColumn
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.utils.Dimen32dp
import com.example.appcarrefour.utils.Dimen350dp

@Composable
fun MainScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        MainHeader()
        CarrefourColumn(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = Dimen32dp, topEnd = Dimen32dp)
                )
                .height(Dimen350dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ButtonCashier { route ->
                    navController.navigate(route)
                }
                ButtonReports { route ->
                    navController.navigate(route)
                }
            }
            CarrefourIcon()
        }
    }
}