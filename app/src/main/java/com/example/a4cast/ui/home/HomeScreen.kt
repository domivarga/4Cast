package com.example.a4cast.ui.home

import com.example.a4cast.model.WeatherDTO

interface HomeScreen {
    fun displayWeatherData(weatherDTO: WeatherDTO)
}