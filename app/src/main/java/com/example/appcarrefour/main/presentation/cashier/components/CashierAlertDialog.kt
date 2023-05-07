package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appcarrefour.ui.theme.Primary
import com.example.appcarrefour.utils.Dimen8dp

@Composable
inline fun CashierAlertDialog(
    openDialog: MutableState<Pair<Boolean, String>>,
    crossinline dismissRequest: (Pair<Boolean, String>) -> Unit
) {
    if (openDialog.value.first) {
        AlertDialog(
            backgroundColor = Color.White,
            onDismissRequest = {
                dismissRequest(false to openDialog.value.second)
            },
            title = {
                Text(
                    text = if (openDialog.value.second == SAVE_MONEY_TYPE) "Registrar ganho?" else "Registrar gasto?",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(all = Dimen8dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    OutlinedButton(
                        onClick = {
                            dismissRequest(true to openDialog.value.second)
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Primary
                        ),
                        border = BorderStroke(1.dp, color = Primary)
                    ) {
                        Text("Sim")
                    }
                    OutlinedButton(
                        onClick = {
                            dismissRequest(false to openDialog.value.second)
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Primary
                        ),
                        border = BorderStroke(1.dp, color = Primary)
                    ) {
                        Text("Não")
                    }
                }
            }
        )
    }
}