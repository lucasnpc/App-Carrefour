package com.example.appcarrefour.main.presentation.report

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appcarrefour.data.dto.CashRegisterDto
import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.di.MainModule
import com.example.appcarrefour.main.presentation.cashier.components.SAVE_MONEY_TYPE
import com.example.appcarrefour.main.presentation.data.FakeCarrefourRepository
import com.example.appcarrefour.utils.MainCoroutineRule
import com.example.appcarrefour.utils.toDate
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class ReportViewmodelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: CarrefourRepository
    private lateinit var reportViewmodel: ReportViewmodel
    private val list = listOf(
        CashRegisterDto(
            description = "Example",
            value = 12.0,
            date = Date("25/02/2029".toDate().time),
            type = SAVE_MONEY_TYPE
        ),
        CashRegisterDto(
            description = "Example",
            value = 12.0,
            date = Date("24/02/2029".toDate().time),
            type = SAVE_MONEY_TYPE
        ),
    )

    @Before
    fun setUp() {
        repository = FakeCarrefourRepository(list)
        reportViewmodel = ReportViewmodel(MainModule.provideMainUsecases(repository))
    }

    @Test
    fun `Get cash registers by date and verify if the list isnt empty`() {
        reportViewmodel.getReportsByDate("24/02/2029", "25/02/2029")

        assertThat(reportViewmodel.cashRegisterList.value, not(`is`(emptyList())))
    }
}