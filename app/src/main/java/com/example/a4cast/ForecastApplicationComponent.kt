package com.example.a4cast

import dagger.Component
import com.example.a4cast.ui.detail.DetailActivity
import com.example.a4cast.ui.home.HomeActivity
import com.example.a4cast.interactor.InteractorModule
import com.example.a4cast.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [InteractorModule::class, UIModule::class])
interface ForecastApplicationComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(detailActivity: DetailActivity)
}