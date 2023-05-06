package com.example.appcarrefour.main.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Store
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.main.utils.MainRoutes
import com.example.appcarrefour.utils.Dimen122dp
import com.example.appcarrefour.utils.Dimen60dp
import com.example.appcarrefour.utils.Font24sp

@Composable
inline fun ButtonCashier(crossinline navigate: (String) -> Unit) {
    Button(
        onClick = {
            navigate(MainRoutes.CashierScreen.route)
        },
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
}