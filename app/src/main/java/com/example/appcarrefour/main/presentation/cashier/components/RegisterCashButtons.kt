package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.Savings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.PrimaryGreen
import com.example.appcarrefour.ui.theme.PrimaryRed
import com.example.appcarrefour.utils.Dimen150dp

@Composable
fun RegisterCashButtons(
    openDialog: MutableState<Pair<Boolean, String>>,
    description: String,
    isDescriptionFieldError: MutableState<Boolean>
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedButton(
            onClick = {
                if (description.isEmpty()) {
                    isDescriptionFieldError.value = true
                    return@OutlinedButton
                }
                openDialog.value = true to SAVE_MONEY_TYPE
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryGreen),
            modifier = Modifier.width(Dimen150dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Savings, contentDescription = stringResource(
                    R.string.save_money_icon_description
                ), tint = Color.White
            )
        }
        OutlinedButton(
            onClick = {
                if (description.isEmpty()) {
                    isDescriptionFieldError.value = true
                    return@OutlinedButton
                }
                openDialog.value = true to SPEND_MONEY_TYPE
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryRed),
            modifier = Modifier.width(Dimen150dp)
        ) {
            Icon(
                imageVector = Icons.Filled.MoneyOff,
                contentDescription = stringResource(
                    R.string.spend_money_icon_description
                ), tint = Color.White
            )
        }
    }
}

const val SAVE_MONEY_TYPE = "Save"
const val SPEND_MONEY_TYPE = "Spend"