package com.example.appcarrefour.main.di

import android.app.Application
import com.example.appcarrefour.di.AppModule
import com.example.appcarrefour.di.ViewmodelModule
import com.example.appcarrefour.domain.data.CarrefourRepository
import com.example.appcarrefour.main.domain.MainUseCases
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MainModuleTest {
    private lateinit var carrefourRepository: CarrefourRepository
    private val context = Mockito.mock(Application::class.java)
    private var mainUseCases: MainUseCases? = null

    @Before
    fun setUp() {
        carrefourRepository =
            ViewmodelModule.provideCarrefourRepository(AppModule.provideDatabaseDao(context))
    }

    @Test
    fun `Assert that carrefour Dao is being properly injected`() {
        assert(mainUseCases == null)
        mainUseCases = MainModule.provideMainUsecases(carrefourRepository)
        assert(mainUseCases != null)
    }
}