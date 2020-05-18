package com.example.a4cast

import com.example.a4cast.mock.MockNetworkModule
import com.example.a4cast.test.WeatherTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class])
interface TestComponent : ForecastApplicationComponent {
    fun inject(artistsTest: WeatherTest)
}