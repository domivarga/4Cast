package com.example.a4cast.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a4cast.model.City

@Dao
interface CityDao {
    @Query("Select * FROM city")
    fun getFavouriteCities(): List<City>

    @Query("SELECT * FROM city where name = :cityId LIMIT 1")
    fun getCity(cityId: String): City

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(city: City)

    @Query("DELETE FROM city where name = :cityId")
    fun removeFavourite(cityId: String)
}