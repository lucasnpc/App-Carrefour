package com.example.appcarrefour.main.presentation.cashier

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcarrefour.main.domain.MainUseCases
import com.example.appcarrefour.main.domain.model.CashRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CashierViewmodel @Inject constructor(private val mainUseCases: MainUseCases) : ViewModel() {

    fun saveCashRegister(cashRegister: CashRegister) {
        viewModelScope.launch {
            mainUseCases.saveCashRegisterUsecase(cashRegister)
        }
    }
}