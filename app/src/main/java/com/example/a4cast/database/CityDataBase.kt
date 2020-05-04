package com.example.a4cast.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4cast.model.City

@Database(entities = [City::class], version = 1)
abstract class  FavouriteCityRoomDataBase : RoomDatabase() {
    abstract fun cityDao() : CityDao
}