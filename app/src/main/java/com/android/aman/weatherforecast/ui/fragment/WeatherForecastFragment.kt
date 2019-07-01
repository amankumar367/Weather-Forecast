package com.android.aman.weatherforecast.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.aman.weatherforecast.R
import com.android.aman.weatherforecast.api.repo.WeatherForecastRepo
import com.android.aman.weatherforecast.ui.WeatherForecastViewModel

class WeatherForecastFragment : Fragment() {

    private lateinit var root : View
    private lateinit var cityName : String
    private lateinit var viewModel : WeatherForecastViewModel
    private lateinit var weatherForecastRepo: WeatherForecastRepo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_weather_forecast, container, false)
        getCityName()
        init()
        setObserver()
        return root
    }

    private fun init() {
        weatherForecastRepo = WeatherForecastRepo(cityName)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(WeatherForecastViewModel::class.java)
        }!!
        viewModel.setRepository(weatherForecastRepo)
        viewModel.getWeatherData()
        viewModel.getWeatherForecastDat()
    }

    private fun setObserver() {

    }

    private fun getCityName() {
        arguments?.let {
            arguments?.getString(CITY_NAME)?.let {
                cityName = it
            } ?: run{
                cityName = "Chandigarh"
            }
        } ?: run{
            cityName = "Chandigarh"
        }
    }

    companion object{
        const val CITY_NAME = "city_name"
    }
}