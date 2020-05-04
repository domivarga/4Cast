package com.example.a4cast.database

import com.example.a4cast.model.City

interface DataBase {
    fun getFavourites(): List<City>
    fun getCity(cityId: String): City
    fun insertFavourite(city : City)
    fun removeFavourite(cityId: String)
}