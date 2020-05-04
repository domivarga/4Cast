package com.example.a4cast.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey
    val id: String,
    val name: String,
    val isFavourite: Boolean
)