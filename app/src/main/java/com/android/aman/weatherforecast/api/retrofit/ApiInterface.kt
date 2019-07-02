package com.android.aman.weatherforecast.api.retrofit

import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.data.WeatherForecastData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?")
    fun getWeatherDetails(
        @Query("q") city:String,
        @Query("APPID") appId:String) : Observable<WeatherData>

    @GET("forecast?")
    fun getWeatherForecastDetails(
        @Query("q") city:String,
        @Query("APPID") appId:String) : Observable<WeatherForecastData>

}