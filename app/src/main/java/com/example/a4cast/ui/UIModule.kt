package com.example.a4cast.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import com.example.a4cast.ui.detail.DetailPresenter
import com.example.a4cast.ui.home.HomePresenter
import com.example.a4cast.interactor.weather.WeatherInteractor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {
    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideNetworkExecutor() = Executors.newFixedThreadPool(1)

    @Provides
    @Singleton
    fun provideHomePresenter(weatherInteractor: WeatherInteractor) =
        HomePresenter(weatherInteractor)

    @Provides
    @Singleton
    fun provideDetailPresenter(weatherInteractor: WeatherInteractor) =
        DetailPresenter(weatherInteractor)
}