package com.example.a4cast.test

import android.content.ClipData
import com.example.a4cast.mock.MockWeatherApi
import com.example.a4cast.testInjector
import com.example.a4cast.ui.home.HomePresenter
import com.example.a4cast.ui.home.HomeScreen
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class WeatherTest {
    @Inject
    lateinit var weatherAPI: MockWeatherApi

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
    }

    @Test
    fun testWeatherDownload() {
        val response = weatherAPI.getWeatherData("","","metric").execute()
        val body = response.body()

        assertEquals("Budapest", body!!.name)
    }
}