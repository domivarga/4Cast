package com.example.a4cast.interactor.weather

import android.util.Log
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.network.NetworkConfig
import com.example.a4cast.network.WeatherApi
import dagger.Module
import javax.inject.Inject

@Module
class WeatherInteractor @Inject constructor(private var weatherApi: WeatherApi) {
    fun downloadWeatherData(city: String) {
        val any = try {
            val weatherQueryCall = weatherApi.getWeatherData(city, NetworkConfig.API_KEY)

            val response = weatherQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            val weatherModel = response.body()
            val weatherDto = WeatherDTO(weatherModel?.main?.temp.toString(), weatherModel?.main?.humidity.toString(), weatherModel?.name ?: "")
        } catch (e: Exception) {
            Log.d("Error", e.message)
        }
    }
}