package com.example.a4cast.database

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): DataBase {
        return CityDataBaseImp(context)
    }

}