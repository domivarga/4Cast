package com.example.a4cast.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(val name: String, val isFavourite: Boolean) {
    @PrimaryKey(autoGenerate = true)
    var id: Integer? = null
}