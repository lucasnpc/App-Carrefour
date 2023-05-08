package com.example.appcarrefour.main.presentation.cashier

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.di.MainModule
import com.example.appcarrefour.main.domain.model.CashRegister
import com.example.appcarrefour.main.presentation.cashier.components.SAVE_MONEY_TYPE
import com.example.appcarrefour.main.presentation.cashier.utils.CashierState
import com.example.appcarrefour.main.presentation.data.FakeCarrefourRepository
import com.example.appcarrefour.utils.MainCoroutineRule
import com.example.appcarrefour.utils.toBrazilianDateFormat
import com.example.appcarrefour.utils.toDate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class CashierViewmodelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: CarrefourRepository
    private lateinit var cashierViewmodel: CashierViewmodel
    private val register = CashRegisterDto(
        description = "Example",
        value = 12.0,
        date = Date("25/02/2029".toDate().time),
        type = SAVE_MONEY_TYPE
    )

    @Before
    fun setUp() {
        repository = FakeCarrefourRepository(listOf())
        cashierViewmodel =
            CashierViewmodel(MainModule.provideMainUsecases(repository))
    }

    @Test
    fun `Assert that save cash register is returning success state`() = runBlocking {
        val job = launch(mainCoroutineRule.dispatcher) {
            cashierViewmodel.state.collectLatest {
                assertThat(it, `is`(CashierState.SUCCESS))
            }
        }
        cashierViewmodel.saveCashRegister(
            CashRegister(
                register.description,
                value = register.value.toString(),
                date = register.date.toBrazilianDateFormat(),
                register.type
            )
        )
        job.cancel()
    }
}