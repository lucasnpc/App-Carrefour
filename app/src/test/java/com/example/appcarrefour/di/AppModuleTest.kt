package com.example.appcarrefour.di

import android.app.Application
import com.example.appcarrefour.data.dao.CarrefourDao
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class AppModuleTest {

    private var carrefourDao: CarrefourDao? = null
    private val context = mock(Application::class.java)

    @Test
    fun `Assert that carrefour Dao is being properly injected`() {
        assert(carrefourDao == null)
        carrefourDao = AppModule.provideDatabaseDao(context)
        assert(carrefourDao != null)
    }
}