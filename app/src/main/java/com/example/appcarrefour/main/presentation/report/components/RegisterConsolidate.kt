package com.example.appcarrefour.main.presentation.report.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.components.SAVE_MONEY_TYPE
import com.example.appcarrefour.main.presentation.cashier.components.SPEND_MONEY_TYPE
import com.example.appcarrefour.ui.theme.NeutralGray

@Composable
fun RegisterConsolidate(list: List<CashRegister>) {
    val savesSum =
        list.sumOf { if (it.type == SAVE_MONEY_TYPE) it.value.toDouble() else 0.0 }
    val spendsSum =
        list.sumOf { if (it.type == SPEND_MONEY_TYPE) it.value.toDouble() else 0.0 }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = NeutralGray)
    ) {
        Column {
            Text(text = "Total de registros: ${list.size}", color = Color.Black)
            Text(text = "Balanço: ${savesSum - spendsSum}", color = Color.Black)
        }
    }
}