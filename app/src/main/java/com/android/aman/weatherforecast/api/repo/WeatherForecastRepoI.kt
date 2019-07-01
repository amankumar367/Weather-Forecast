package com.android.aman.weatherforecast.api.repo

import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.retrofit.ApiCallBack

interface WeatherForecastRepoI {
    fun getWeather(apiCallBack: ApiCallBack<WeatherData>)
}