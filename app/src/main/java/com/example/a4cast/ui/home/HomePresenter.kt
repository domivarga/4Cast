package com.example.a4cast.ui.home

import android.util.Log
import com.example.a4cast.database.DataBase
import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.interactor.weather.event.GetWeatherEvent
import com.example.a4cast.model.City
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class HomePresenter @Inject constructor(private val weatherInteractor: WeatherInteractor,
                                        private val executor: Executor): Presenter<HomeScreen>() {

    override fun attachScreen(screen: HomeScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    fun loadWeatherData() {
        loadWeather()
    }

    private fun loadWeather() {
        val cities = weatherInteractor.getCities()
        Log.d("CITIES", "$cities")

        executor.execute {
            weatherInteractor.downloadWeatherData("Budapest")
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetWeatherEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
        } else {
            if (screen != null) {
                if (event.weather != null) {

                    weatherInteractor.saveCity(City(event.weather!!.main.temp.toString(), true))

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