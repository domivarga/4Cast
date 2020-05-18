package com.example.a4cast.ui.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a4cast.R
import com.example.a4cast.injector
import com.example.a4cast.ui.home.NavigationKeys
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(),
    DetailScreen {

    @Inject
    lateinit var detailPresenter: DetailPresenter
    lateinit var cityNameLabel: TextView
    lateinit var temperatureLabel: TextView
    lateinit var humidityLabel: TextView

    private var cityName: String? = null
    private var temperature: String? = null
    private var humidity: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val bundle=intent.extras
        if(bundle!=null)
        {
            cityName = bundle.getString(NavigationKeys.KEY_NAME)
            temperature = bundle.getString(NavigationKeys.KEY_TEMPERATURE)
            humidity = bundle.getString(NavigationKeys.KEY_HUMIDITY)
        }

        injector.inject(this)
        detailPresenter.attachScreen(this)

        initializeViews()
        detailPresenter?.loadDetailData()
    }

    private fun initializeViews() {
        cityNameLabel = findViewById(R.id.city_name_label) as TextView
        temperatureLabel = findViewById(R.id.temperature_label) as TextView
        humidityLabel = findViewById(R.id.humidity_label) as TextView
    }

    override fun displayDetailData() {
        cityNameLabel.text = cityName
        temperatureLabel.text = temperature
        humidityLabel.text = humidity
    }

}