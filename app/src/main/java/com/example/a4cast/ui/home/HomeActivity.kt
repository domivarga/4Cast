package com.example.a4cast.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.a4cast.R
import com.example.a4cast.database.CityDataBaseImp
import com.example.a4cast.injector
import kotlinx.android.synthetic.main.activity_main.*
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.ui.detail.DetailActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeScreen {
    companion object {
        var database: CityDataBaseImp? = null
    }

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        injector.inject(this)
        HomeActivity.database = CityDataBaseImp(this)
    }

    override fun onStart() {
        super.onStart()

        homePresenter.loadWeatherData()
    }

    override fun displayWeatherData(weatherDTO: WeatherDTO) {
        // Display weather data.
        Log.d("xxx NAME", weatherDTO.city)
        Log.d("xxx HUMIDITY", weatherDTO.hum)
        Log.d("xxx TEMP", weatherDTO.temp)
    }

    private fun navigate() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

}
