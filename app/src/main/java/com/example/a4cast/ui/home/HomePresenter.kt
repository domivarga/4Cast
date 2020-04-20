package com.example.a4cast.ui.home

import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.model.Weather
import com.example.a4cast.ui.Presenter
import javax.inject.Inject

class HomePresenter @Inject constructor(private val weatherInteractor: WeatherInteractor): Presenter<HomeScreen>() {

    fun loadWeatherData() {
        loadWeather()
    }

    private fun loadWeather() {
        // get weather data from repository
        screen?.displayWeatherData(
            Weather(
                "ad",
                "asd",
                "asd"
            )
        )
    }


}