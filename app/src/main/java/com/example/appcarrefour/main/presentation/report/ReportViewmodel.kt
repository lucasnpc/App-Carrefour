package com.example.appcarrefour.main.presentation.report

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcarrefour.main.domain.MainUseCases
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.utils.Result
import com.example.appcarrefour.utils.toBrazilianDateFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ReportViewmodel @Inject constructor(private val mainUseCases: MainUseCases) : ViewModel() {

    val cashRegisterList = mutableStateOf(listOf<CashRegister>())

    init {
        val today = Date()
        getReportsByDate(today.toBrazilianDateFormat(), today.toBrazilianDateFormat())
    }

    fun getReportsByDate(beginDate: String, endDate: String = Date().toBrazilianDateFormat()) {
        viewModelScope.launch {
            mainUseCases.getCashRegisterByDateUsecase(beginDate, endDate).let {
                when (it) {
                    is Result.Success -> {
                        cashRegisterList.value = it.data
                    }
                    else -> Unit
                }
            }
        }
    }
}
