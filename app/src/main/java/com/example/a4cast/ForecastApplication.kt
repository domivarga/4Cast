package com.example.a4cast
import android.app.Application
import com.example.a4cast.ui.UIModule

class ForecastApplication: Application() {
    lateinit var injector: ForecastApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerForecastApplicationComponent.builder().uIModule(
            UIModule(
                (this)
            )
        ).build()
    }
}