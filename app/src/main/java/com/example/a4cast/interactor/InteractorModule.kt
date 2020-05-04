package com.example.a4cast.interactor

import dagger.Module
import dagger.Provides
import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.network.WeatherApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideWeatherInteractor(weatherApi: WeatherApi) = WeatherInteractor(weatherApi)
}