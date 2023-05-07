package com.example.appcarrefour.main.presentation.report.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.appcarrefour.R
import com.example.appcarrefour.main.presentation.report.exampleItems
import com.example.appcarrefour.utils.Dimen90dp

@Composable
fun DescriptionColumn(){
    Column {
        Text(stringResource(id = R.string.description), color = Color.Black)
        exampleItems.forEach { item ->
            Text(
                text = item.description,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.width(Dimen90dp)
            )
        }
    }
}