package com.example.a4cast.interactor

import com.example.a4cast.database.DataBase
import dagger.Module
import dagger.Provides
import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.network.WeatherApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideWeatherInteractor(weatherApi: WeatherApi, dataBase: DataBase) = WeatherInteractor(weatherApi, dataBase)
}