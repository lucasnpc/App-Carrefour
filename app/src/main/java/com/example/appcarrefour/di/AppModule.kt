package com.example.appcarrefour.di

import android.app.Application
import androidx.room.Room
import com.example.appcarrefour.data.CarrefourDatabase
import com.example.appcarrefour.data.dao.CarrefourDao
import com.example.appcarrefour.data.repository.CarrefourRepositoryImpl
import com.example.appcarrefour.domain.data.CarrefourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabaseDao(app: Application): CarrefourDao =
        Room.databaseBuilder(app, CarrefourDatabase::class.java, CarrefourDatabase.DB_NAME).build()
            .carrefourDao()
}

@Module
@InstallIn(ViewModelComponent::class)
object ViewmodelModule {
    @Provides
    @ViewModelScoped
    fun provideCarrefourRepository(carrefourDao: CarrefourDao): CarrefourRepository =
        CarrefourRepositoryImpl(carrefourDao)
}
