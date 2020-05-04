package com.example.a4cast.ui.home

import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.interactor.weather.event.GetWeatherEvent
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class HomePresenter @Inject constructor(private val weatherInteractor: WeatherInteractor): Presenter<HomeScreen>() {

    fun loadWeatherData() {
        EventBus.getDefault().register(this)
        loadWeather()
    }

    private fun loadWeather() {
        weatherInteractor.downloadWeatherData("Budapest")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetWeatherEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
        } else {
            if (screen != null) {
                if (event.weather != null) {
                    screen?.displayWeatherData(
                        WeatherDTO(
                            event.weather!!.main.temp.toString(),
                            event.weather!!.main.humidity.toString(),
                            event.weather!!.name
                        )
                    )
                }

            }
        }
    }
}