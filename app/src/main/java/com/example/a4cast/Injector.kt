package com.example.a4cast

import android.app.Activity
import com.example.a4cast.ForecastApplication
import com.example.a4cast.ForecastApplicationComponent

val Activity.injector: ForecastApplicationComponent
    get() {
        return (applicationContext as ForecastApplication).injector
    }