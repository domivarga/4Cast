package com.example.a4cast.ui.detail

import com.example.a4cast.ui.Presenter
import com.example.a4cast.interactor.weather.WeatherInteractor
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val weatherInteractor: WeatherInteractor): Presenter<DetailScreen>() {
    fun loadDetailData() {
        // interactor call
        screen?.displayDetailData()
    }
}