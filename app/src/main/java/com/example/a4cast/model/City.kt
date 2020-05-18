package com.example.a4cast.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(val name: String, val temperature: String, val humidity: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Integer? = null
}