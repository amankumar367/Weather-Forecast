package com.android.aman.weatherforecast.ui

import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.data.WeatherForecastData

data class WeatherForecastState(
    var isSuccess: Boolean = false,
    var isLoading: Boolean = false,
    var cityName: String = "" ,
    var temp: String = "",
    var mintemp: String = "",
    var maxtemp: String = "",
    var discription: String = "",
    var message: String = "",
    var weatherData: WeatherData? = null,
    var weatherForecastData: WeatherForecastData? = null) {

    companion object {
        fun showLoading(): WeatherForecastState {
            return WeatherForecastState(isLoading = true, message =  "Loading.....")
        }

        fun showSuccessWeatherForecast(weatherData: WeatherData): WeatherForecastState {
            return WeatherForecastState(
                isSuccess = true,
                isLoading = false,
                cityName = weatherData.name!!,
                temp = weatherData.main!!.temp.toString(),
                mintemp = weatherData.main!!.tempMin.toString(),
                maxtemp = weatherData.main!!.tempMax.toString(),
                discription = weatherData.weather!![0]!!.description!!,
                message = "Loaded Successfully",
                weatherData = weatherData
            )
        }

        fun showError(message: String): WeatherForecastState {
            return WeatherForecastState(false, message = message)
        }

    }
}