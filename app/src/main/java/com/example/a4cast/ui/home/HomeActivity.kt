package com.example.a4cast.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.a4cast.R
import com.example.a4cast.injector
import com.example.a4cast.model.WeatherDTO
import com.example.a4cast.ui.detail.DetailActivity
import com.example.a4cast.ui.home.NavigationKeys.KEY_HUMIDITY
import com.example.a4cast.ui.home.NavigationKeys.KEY_NAME
import com.example.a4cast.ui.home.NavigationKeys.KEY_TEMPERATURE
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), HomeScreen {

    @Inject
    lateinit var homePresenter: HomePresenter
    lateinit var searchBar: EditText

    lateinit var weatherDTO: WeatherDTO

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        injector.inject(this)
        homePresenter.attachScreen(this)

        setupSearchBar()
    }

    override fun onStart() {
        super.onStart()

        homePresenter.loadWeatherData()
    }

    override fun displayWeatherData(weatherDTO: WeatherDTO) {
        this.weatherDTO = weatherDTO
    }

    override fun showDetailedWeather(weatherDTO: WeatherDTO) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NavigationKeys.KEY_NAME, weatherDTO.city)
        intent.putExtra(NavigationKeys.KEY_TEMPERATURE, weatherDTO.temp)
        intent.putExtra(NavigationKeys.KEY_HUMIDITY, weatherDTO.hum)
        startActivity(intent)
    }

    private fun navigateToDetails() {
        homePresenter?.showDetail(weatherDTO)
    }

    private fun setupSearchBar() {
        searchBar = findViewById<EditText>(R.id.searchBar) as EditText

        searchBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                navigateToDetails()
                homePresenter.loadWeatherData()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }
}

object NavigationKeys {
    const val KEY_NAME = "KEY_NAME"
    const val KEY_TEMPERATURE = "KEY_TEMPERATURE"
    const val KEY_HUMIDITY = "KEY_HUMIDITY"
}