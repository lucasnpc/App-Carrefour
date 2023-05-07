package com.example.appcarrefour.main.presentation.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.components.SAVE_MONEY_TYPE
import com.example.appcarrefour.main.presentation.cashier.components.SPEND_MONEY_TYPE
import com.example.appcarrefour.main.presentation.report.components.FilterDate
import com.example.appcarrefour.main.presentation.report.components.RegisterConsolidate
import com.example.appcarrefour.main.presentation.report.components.ReportHeader
import com.example.appcarrefour.main.presentation.report.components.ReportsList
import com.example.appcarrefour.ui.commons.CarrefourColumn
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.ui.commons.carrefourDatePickDialog
import com.example.appcarrefour.utils.Dimen10dp
import com.example.appcarrefour.utils.Dimen16dp
import com.example.appcarrefour.utils.Dimen32dp
import com.example.appcarrefour.utils.Dimen650dp

val exampleItems = listOf(
    CashRegister("dasdsadasdasdasdasdas", 123.0, "24/02/1999", SPEND_MONEY_TYPE),
    CashRegister("null", 123.0, "24/02/1999", SAVE_MONEY_TYPE),
    CashRegister("null", 123.0, "24/02/1999", SAVE_MONEY_TYPE)
)

@Composable
fun ReportScreen() {
    val date = remember { mutableStateOf("") }
    val context = LocalContext.current

    val datePickerDialog = carrefourDatePickDialog(context, date)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        ReportHeader()
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
                ReportsList()
                Spacer(modifier = Modifier.height(Dimen10dp))
                RegisterConsolidate()
                Spacer(modifier = Modifier.height(Dimen10dp))
                FilterDate(date, datePickerDialog)
            }
            CarrefourIcon()
        }
    }
}