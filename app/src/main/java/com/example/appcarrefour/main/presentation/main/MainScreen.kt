package com.example.appcarrefour.main.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Store
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appcarrefour.R
import com.example.appcarrefour.main.utils.MainRoutes
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.utils.*

@Composable
fun MainScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = Dimen80dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = stringResource(id = R.string.person_icon_description),
                modifier = Modifier
                    .width(Dimen48dp)
                    .height(Dimen48dp),
                tint = Color.White
            )
            Text(text = "Carrefour", color = Color.White, fontSize = Font24sp)
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = Dimen32dp, topEnd = Dimen32dp)
                )
                .height(Dimen350dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate(MainRoutes.CashierScreen.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Outlined.Store, contentDescription = stringResource(
                                R.string.store_icon_description
                            ), modifier = Modifier
                                .width(Dimen122dp)
                                .height(Dimen60dp),
                            tint = Color.White
                        )
                        Text(
                            text = stringResource(R.string.cashier),
                            color = Color.White,
                            fontSize = Font24sp
                        )
                    }
                }
                Button(
                    onClick = { navController.navigate(MainRoutes.ReportScreen.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Outlined.Store, contentDescription = stringResource(
                                R.string.store_icon_description
                            ), modifier = Modifier
                                .width(Dimen122dp)
                                .height(Dimen60dp),
                            tint = Color.White
                        )
                        Text(
                            text = stringResource(R.string.reports),
                            color = Color.White,
                            fontSize = Font24sp
                        )
                    }
                }
            }
            CarrefourIcon()
        }
    }
}