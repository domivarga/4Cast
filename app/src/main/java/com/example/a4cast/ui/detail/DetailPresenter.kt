package com.example.a4cast.ui.detail

import com.example.a4cast.ui.Presenter
import com.example.a4cast.interactor.weather.WeatherInteractor
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val weatherInteractor: WeatherInteractor, private val executor: Executor): Presenter<DetailScreen>() {
    fun loadDetailData() {
        screen?.displayDetailData()
    }
}