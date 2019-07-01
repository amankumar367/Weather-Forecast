package com.android.aman.weatherforecast.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.repo.WeatherForecastRepoI
import com.android.aman.weatherforecast.api.retrofit.ApiCallBack

class WeatherForecastViewModel : ViewModel() {

    private lateinit var weatherForecastRepoI: WeatherForecastRepoI

    fun setRepository(weatherForecastRepoI: WeatherForecastRepoI){
        this.weatherForecastRepoI = weatherForecastRepoI
    }

    fun getWeatherData(){
        weatherForecastRepoI.getWeather(object : ApiCallBack<WeatherData>{
            override fun onSuccess(t: WeatherData) {
                Log.e(TAG, "onSuccess - $t")
            }

            override fun onFailure(message: String) {
                Log.e(TAG, "onFailure - $message")
            }
        })
    }

    companion object{
        const val TAG = "Weather Forecast"
    }

}