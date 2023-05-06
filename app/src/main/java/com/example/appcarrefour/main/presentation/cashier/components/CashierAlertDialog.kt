package com.example.appcarrefour.main.presentation.cashier.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.appcarrefour.utils.Dimen8dp

@Composable
inline fun CashierAlertDialog(
    openDialog: MutableState<Pair<Boolean, String>>,
    crossinline dismissRequest: (Boolean) -> Unit
) {
    if (openDialog.value.first) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false to ""
                dismissRequest(false)
            },
            title = {
                Text(
                    text = if (openDialog.value.second == SAVE_MONEY) "Registrar ganho?" else "Registrar gasto?",
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
                            openDialog.value = false to ""
                            dismissRequest(true)
                        }
                    ) {
                        Text("Sim")
                    }
                    OutlinedButton(
                        onClick = {
                            openDialog.value = false to ""
                            dismissRequest(false)
                        }
                    ) {
                        Text("Não")
                    }
                }
            }
        )
    }
}