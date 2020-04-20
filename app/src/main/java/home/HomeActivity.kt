package home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.example.a4cast.R
import kotlinx.android.synthetic.main.activity_main.*
import repository.Weather

class HomeActivity : AppCompatActivity(), HomeContract.HomeView {

    private var presenter: HomeContract.HomePresenter = HomePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onViewCreated()
    }

    override fun displayWeatherData(weather: Weather) {
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Display weather data.
    }

}
