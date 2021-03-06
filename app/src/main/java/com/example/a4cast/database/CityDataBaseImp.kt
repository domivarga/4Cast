package com.example.a4cast.database

import android.content.Context
import androidx.room.Room
import com.example.a4cast.model.City

class CityDataBaseImp(context: Context) : DataBase {
    private var cityDao: CityDao

    init {
        val database = Room.databaseBuilder(
            context,
            FavouriteCityRoomDataBase::class.java,
            "CityRoomDataBase.db")
            .allowMainThreadQueries()
            .build()
        cityDao = database.cityDao()
    }

    override fun getFavourites() = cityDao.getFavouriteCities()

    override fun getCity(cityId: String): City = cityDao.getCity(cityId)

    override fun insertFavourite(city: City) = cityDao.insertFavourite(city)

    override fun removeFavourite(cityId: String) = cityDao.removeFavourite(cityId)
}