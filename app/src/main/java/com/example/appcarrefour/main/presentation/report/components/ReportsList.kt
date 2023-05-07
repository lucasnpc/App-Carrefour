package com.example.appcarrefour.main.presentation.report.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appcarrefour.ui.theme.NeutralGray
import com.example.appcarrefour.utils.Dimen370dp
import com.example.appcarrefour.utils.Dimen8dp

@Composable
fun ReportsList(){
    LazyColumn(
        modifier = Modifier
            .height(Dimen370dp)
            .background(color = NeutralGray)
            .padding(Dimen8dp)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                DescriptionColumn()
                ValueColumn()
                DateColumn()
                TypeColumn()
            }
        }
    }
}