package com.example.appcarrefour.main.presentation.report.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.main.domain.model.CashRegister

@Composable
fun ValueColumn(list: List<CashRegister>) {
    Column {
        Text(stringResource(id = R.string.value), color = Color.Black)
        list.forEach { item ->
            Text(text = item.value, color = Color.Black)
        }
    }
}