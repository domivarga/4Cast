package com.example.a4cast.mock

import com.example.a4cast.network.WeatherApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi = MockWeatherApi()
}