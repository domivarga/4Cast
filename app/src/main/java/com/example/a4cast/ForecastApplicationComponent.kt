package com.example.a4cast

import com.example.a4cast.database.DatabaseModule
import dagger.Component
import com.example.a4cast.ui.detail.DetailActivity
import com.example.a4cast.ui.home.HomeActivity
import com.example.a4cast.interactor.InteractorModule
import com.example.a4cast.network.NetworkModule
import com.example.a4cast.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class, DatabaseModule::class])
interface ForecastApplicationComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(detailActivity: DetailActivity)
}