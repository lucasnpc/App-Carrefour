package com.example.appcarrefour.di

import android.app.Application
import com.example.appcarrefour.domain.data.CarrefourRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ViewmodelModuleTest {
    private var carrefourRepository: CarrefourRepository? = null
    private val context = Mockito.mock(Application::class.java)

    @Test
    fun `Assert that carrefour repository is being properly injected`() {
        assert(carrefourRepository == null)
        carrefourRepository =
            ViewmodelModule.provideCarrefourRepository(AppModule.provideDatabaseDao(context))
        assert(carrefourRepository != null)
    }
}