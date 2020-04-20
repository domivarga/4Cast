package home

import repository.Weather

interface HomeContract {
    interface HomeView {
        fun displayWeatherData(weather: Weather)
    }

    interface HomePresenter {
        fun onViewCreated()
    }
}