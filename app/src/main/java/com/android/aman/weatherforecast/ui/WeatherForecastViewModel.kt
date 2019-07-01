package com.android.aman.weatherforecast.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.data.WeatherForecastData
import com.android.aman.weatherforecast.api.repo.WeatherForecastRepoI
import com.android.aman.weatherforecast.api.retrofit.ApiCallBack

class WeatherForecastViewModel : ViewModel() {

    private lateinit var weatherForecastRepoI: WeatherForecastRepoI

    internal var state = MutableLiveData<WeatherForecastState>()

    fun setRepository(weatherForecastRepoI: WeatherForecastRepoI){
        this.weatherForecastRepoI = weatherForecastRepoI
    }

    fun getWeatherData(){
        state.postValue(WeatherForecastState.showLoading())
        weatherForecastRepoI.getWeather(object : ApiCallBack<WeatherData>{
            override fun onSuccess(t: WeatherData) {
                state.postValue(WeatherForecastState.showSuccessWeatherForecast(t))
                Log.e(TAG, "onSuccess - $t")
            }

            override fun onFailure(message: String) {
                state.postValue(WeatherForecastState.showError(message))
                Log.e(TAG, "onFailure - $message")
            }
        })
    }

    fun getWeatherForecastDat(){
        weatherForecastRepoI.getWeatherForecast(object : ApiCallBack<WeatherForecastData>{
            override fun onSuccess(t: WeatherForecastData) {
                Log.e(TAG1, "onSuccess - $t")
            }

            override fun onFailure(message: String) {
                Log.e(TAG1, "onFailure - $message")

            }
        })
    }

    companion object{
        const val TAG = "Weather"
        const val TAG1 = "Weather Forecast"

    }

}