package com.example.appcarrefour.main.presentation.cashier

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcarrefour.main.domain.MainUseCases
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.utils.CashierState
import com.example.appcarrefour.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CashierViewmodel @Inject constructor(private val mainUseCases: MainUseCases) : ViewModel() {

    private val _state = MutableSharedFlow<CashierState>()
    val state: MutableSharedFlow<CashierState> = _state

    fun saveCashRegister(cashRegister: CashRegister) {
        viewModelScope.launch {
            when (mainUseCases.saveCashRegisterUsecase(cashRegister)) {
                is Result.Success -> {
                    _state.emit(CashierState.SUCCESS)
                }
                else -> _state.emit(CashierState.ERROR)
            }
        }
    }
}