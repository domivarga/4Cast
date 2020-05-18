package com.example.a4cast.mock

import com.example.a4cast.network.Main
import com.example.a4cast.network.WeatherApi
import com.example.a4cast.network.WeatherModel
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockWeatherApi: WeatherApi {
    override fun getWeatherData(query: String, units: String, appid: String): Call<WeatherModel> {
        val weather = WeatherModel(Main(22.0, 22.0, 22.0, 22.0), "Budapest")

        val call = object : Call<WeatherModel> {
            @Throws(IOException::class)
            override fun execute(): Response<WeatherModel> {
                return Response.success(weather)
            }

            override fun enqueue(callback: Callback<WeatherModel>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<WeatherModel> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                return Timeout.NONE
            }
        }

        return call
    }
}