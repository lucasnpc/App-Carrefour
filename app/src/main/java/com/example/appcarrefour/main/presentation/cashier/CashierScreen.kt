package com.example.appcarrefour.main.presentation.cashier

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.appcarrefour.R
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.components.*
import com.example.appcarrefour.main.presentation.cashier.utils.CashierState
import com.example.appcarrefour.ui.commons.CarrefourColumn
import com.example.appcarrefour.ui.commons.CarrefourIcon
import com.example.appcarrefour.ui.commons.carrefourDatePickDialog
import com.example.appcarrefour.utils.Dimen16dp
import com.example.appcarrefour.utils.Dimen32dp
import com.example.appcarrefour.utils.Dimen650dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun CashierScreen(
    navController: NavHostController,
    cashierViewmodel: CashierViewmodel = hiltViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    var description by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    val context = LocalContext.current

    val date = remember { mutableStateOf("") }

    val datePickerDialog = carrefourDatePickDialog(context, date)

    val openDialog = remember { mutableStateOf(false to "") }

    val isDescriptionFieldError = remember {
        mutableStateOf(false)
    }

    ObserveCashierState(lifecycleOwner, scope, cashierViewmodel, context) {
        navController.popBackStack()
    }

    CashierAlertDialog(openDialog) { pair ->
        if (pair.first) {
            cashierViewmodel.saveCashRegister(
                CashRegister(
                    description,
                    value,
                    date.value,
                    pair.second
                )
            )
        }
        openDialog.value = false to ""
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        CashierHeader()
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
                DescriptionTextField(description, isDescriptionFieldError) {
                    description = it
                }
                ValueTextField(value) {
                    value = it
                }

                SelectDate(date, datePickerDialog)

                Spacer(modifier = Modifier.height(Dimen32dp))
                RegisterCashButtons(openDialog, description, isDescriptionFieldError)
            }
            CarrefourIcon()
        }
    }
}

@Composable
private fun ObserveCashierState(
    lifecycleOwner: LifecycleOwner,
    scope: CoroutineScope,
    cashierViewmodel: CashierViewmodel,
    context: Context,
    onSuccess: () -> Unit
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    scope.launch {
                        cashierViewmodel.state.collectLatest { state ->
                            when (state) {
                                CashierState.SUCCESS -> {
                                    onSuccess()
                                }
                                CashierState.ERROR -> {
                                    Toast.makeText(
                                        context,
                                        R.string.somethiing_went_wrong,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                else -> {}
                            }
                        }
                    }
                }
                Lifecycle.Event.ON_STOP -> scope.coroutineContext.cancelChildren()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }
}