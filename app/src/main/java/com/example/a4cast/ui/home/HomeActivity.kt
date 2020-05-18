package com.example.a4cast.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.a4cast.R
import com.example.a4cast.injector
import com.example.a4cast.model.City
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

    private lateinit var searchBar: EditText
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ArrayAdapter<String?>
    private lateinit var historyItems: List<City>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        injector.inject(this)
        homePresenter.attachScreen(this)

        setupSearchBar()
        setupListView()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun displayWeatherData(weatherDTO: WeatherDTO) {
        navigateToDetails(weatherDTO)
    }

    override fun showDetailedWeather(weatherDTO: WeatherDTO) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NavigationKeys.KEY_NAME, weatherDTO.city)
        intent.putExtra(NavigationKeys.KEY_TEMPERATURE, weatherDTO.temp)
        intent.putExtra(NavigationKeys.KEY_HUMIDITY, weatherDTO.hum)
        startActivity(intent)

        homePresenter?.loadHistory()
    }

    private fun navigateToDetails(weatherDTO: WeatherDTO) {
        homePresenter?.showDetail(weatherDTO)
    }

    private fun setupSearchBar() {
        searchBar = findViewById<EditText>(R.id.searchBar) as EditText

        searchBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                homePresenter.loadWeatherData(searchBar.text.toString())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    override fun showHistoryList(cityList: List<City>) {
        historyItems = cityList
        val listItems = arrayOfNulls<String>(cityList.size)

        for (i in 0 until cityList.size) {
            listItems[i] = cityList[i].name
        }

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = arrayAdapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCity = historyItems[position]
            navigateToDetails(WeatherDTO(selectedCity.temperature, selectedCity.humidity, selectedCity.name))
        }
    }

    private fun setupListView() {
        listView = findViewById<ListView>(R.id.history_list)
        homePresenter?.loadHistory()
    }
}

object NavigationKeys {
    const val KEY_NAME = "KEY_NAME"
    const val KEY_TEMPERATURE = "KEY_TEMPERATURE"
    const val KEY_HUMIDITY = "KEY_HUMIDITY"
}