package com.example.a4cast.interactor

import dagger.Module
import dagger.Provides
import com.example.a4cast.interactor.weather.WeatherInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideWeatherInteractor() =
        WeatherInteractor()
}