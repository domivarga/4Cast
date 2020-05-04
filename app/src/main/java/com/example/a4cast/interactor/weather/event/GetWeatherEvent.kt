package com.example.a4cast.interactor.weather.event

import com.example.a4cast.network.WeatherModel

data class GetWeatherEvent(
    var code: Int = 0,
    var weather: WeatherModel? = null,
    var throwable: Throwable? = null
)