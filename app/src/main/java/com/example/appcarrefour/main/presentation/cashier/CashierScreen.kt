package com.example.appcarrefour.main.presentation.cashier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.components.*
import com.example.appcarrefour.ui.commons.CarrefourColumn
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.ui.commons.carrefourDatePickDialog
import com.example.appcarrefour.utils.Dimen16dp
import com.example.appcarrefour.utils.Dimen32dp
import com.example.appcarrefour.utils.Dimen650dp

@Composable
fun CashierScreen(
    navController: NavHostController,
    cashierViewmodel: CashierViewmodel = hiltViewModel()
) {
    var description by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    val context = LocalContext.current

    val date = remember { mutableStateOf("") }

    val datePickerDialog = carrefourDatePickDialog(context, date)

    val openDialog = remember { mutableStateOf(false to "") }

    CashierAlertDialog(openDialog) { dismiss ->
        if (dismiss) {
            cashierViewmodel.saveCashRegister(
                CashRegister(
                    description,
                    value.toDouble(),
                    date.value,
                    openDialog.value.second
                )
            )
            navController.popBackStack()
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        CashierHeader()
        CarrefourColumn(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = Dimen32dp, topEnd = Dimen32dp)
                )
                .height(Dimen650dp)
                .padding(Dimen16dp)
        ) {
            Column {
                DescriptionTextField(description) {
                    description = it
                }
                ValueTextField(value) {
                    value = it
                }

                SelectDate(date, datePickerDialog)

                Spacer(modifier = Modifier.height(Dimen32dp))
                RegisterCashButtons(openDialog)
            }
            CarrefourIcon()
        }
    }
}