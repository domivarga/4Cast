package com.example.a4cast.interactor.weather

import android.util.Log
import com.example.a4cast.database.DataBase
import com.example.a4cast.interactor.weather.event.GetWeatherEvent
import com.example.a4cast.model.City
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.network.NetworkConfig
import com.example.a4cast.network.WeatherApi
import dagger.Module
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

@Module
class WeatherInteractor @Inject constructor(private var weatherApi: WeatherApi, private val database: DataBase) {
    fun saveCity(city: City) {
        database.insertFavourite(city)
    }

    fun getCities() = database.getFavourites()

    fun downloadWeatherData(city: String) {
        val event = GetWeatherEvent()

        try {
            val weatherQueryCall = weatherApi.getWeatherData(city, NetworkConfig.API_KEY)
            val response = weatherQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.weather = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}