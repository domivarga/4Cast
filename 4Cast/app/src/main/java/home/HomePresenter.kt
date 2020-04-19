package home

import repository.Weather

class HomePresenter(view: HomeContract.HomeView): HomeContract.HomePresenter {
    private var view: HomeContract.HomeView? = view

    override fun onViewCreated() {
        loadWeather()
    }

    private fun loadWeather() {
        // get weather data from repository
        view?.displayWeatherData(Weather())
    }
}