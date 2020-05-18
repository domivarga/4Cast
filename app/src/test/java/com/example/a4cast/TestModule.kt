package com.example.a4cast

import android.content.Context
import com.example.a4cast.interactor.weather.WeatherInteractor
import com.example.a4cast.ui.home.HomePresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideHomePresenter(executor: Executor, weatherInteractor: WeatherInteractor) = HomePresenter(weatherInteractor, executor)
}