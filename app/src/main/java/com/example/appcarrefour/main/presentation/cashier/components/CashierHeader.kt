package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Store
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.utils.Dimen36dp
import com.example.appcarrefour.utils.Dimen4dp
import com.example.appcarrefour.utils.Font24sp

@Composable
fun CashierHeader(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Store,
            contentDescription = stringResource(id = R.string.store_icon_description),
            tint = Color.White,
            modifier = Modifier
                .width(Dimen36dp)
                .height(Dimen36dp)
        )
        Spacer(modifier = Modifier.width(Dimen4dp))
        Text(text = stringResource(id = R.string.cashier), fontSize = Font24sp, color = Color.White)
    }
}