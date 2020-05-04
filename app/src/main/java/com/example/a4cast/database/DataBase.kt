package com.example.a4cast.database

import com.example.a4cast.model.City

interface DataBase {
    fun getFavourites(result: (cities: List<City>) -> Unit)
    fun getCity(cityId: String): City
    fun insertFavourite(city : City)
    fun removeFavourite(cityId: String)
}