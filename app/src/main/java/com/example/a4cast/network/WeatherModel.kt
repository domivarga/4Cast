package com.example.a4cast.network

import com.example.a4cast.model.WeatherDTO
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("main")
    var main: Main,

    @SerializedName("name")
    var name: String
)

data class Main (
    @SerializedName("temp")
    var temp: Double,

    @SerializedName("temp_min")
    var minTemp: Double,

    @SerializedName("temp_max")
    var maxTemp: Double,

    @SerializedName("humidity")
    var humidity: Double
)