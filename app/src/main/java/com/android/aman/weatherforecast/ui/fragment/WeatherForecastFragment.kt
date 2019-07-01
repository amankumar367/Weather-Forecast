package com.android.aman.weatherforecast.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.aman.weatherforecast.R
import com.android.aman.weatherforecast.api.repo.WeatherForecastRepo
import com.android.aman.weatherforecast.databinding.FragmentWeatherForecastBinding
import com.android.aman.weatherforecast.ui.WeatherForecastState
import com.android.aman.weatherforecast.ui.WeatherForecastViewModel

class WeatherForecastFragment : Fragment() {

    private lateinit var dataBinding: FragmentWeatherForecastBinding
    private lateinit var root : View
    private lateinit var cityName : String
    private lateinit var viewModel : WeatherForecastViewModel
    private lateinit var weatherForecastRepo: WeatherForecastRepo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_forecast, container, false)
        root = dataBinding.root
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
        viewModel.state.observe(this, Observer<WeatherForecastState> {state ->
            setUiState(state)
        })
    }

    private fun setUiState(state: WeatherForecastState?) {
        dataBinding.state = state
        when{
            dataBinding.state!!.isSuccess -> {
                toast(dataBinding.state!!.message)
            }
        }
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

    private fun toast(string: String){
        Toast.makeText(root.context, string, Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val CITY_NAME = "city_name"
    }
}