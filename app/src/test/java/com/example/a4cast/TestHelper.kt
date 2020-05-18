package com.example.a4cast

import org.robolectric.RuntimeEnvironment

val testInjector: TestComponent
    get() {
        val application = RuntimeEnvironment.application as ForecastApplicationComponent
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
        application.injector = component
        return component
    }