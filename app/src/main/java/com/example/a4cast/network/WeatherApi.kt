package com.example.a4cast.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    fun getWeatherData(
        @Query("q") query: String,
        @Query("appid") appid: String
    ) : Call<WeatherModel>

}