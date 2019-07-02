package com.android.aman.weatherforecast.ui.fragment

import android.annotation.SuppressLint
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
import com.android.aman.weatherforecast.Utils
import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.data.WeatherForecastData
import com.android.aman.weatherforecast.api.repo.WeatherForecastRepo
import com.android.aman.weatherforecast.databinding.FragmentWeatherForecastBinding
import com.android.aman.weatherforecast.ui.WeatherForecastState
import com.android.aman.weatherforecast.ui.WeatherForecastViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_weather_forecast.view.*

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

        viewModel.stateWeatherForecast.observe(this, Observer<WeatherForecastData>{
            it?.let {
                setWeatherForecastDetails(it)
            } ?: run {
                toast("Failed to fatch weather forecast details")
            }
        })
    }

    private fun setUiState(state: WeatherForecastState?) {
        dataBinding.state = state
        when{
            dataBinding.state!!.isSuccess -> {
                setWeatherDetails(dataBinding.state!!.weatherData)
                toast(dataBinding.state!!.message)
            }
            else -> {
                toast(dataBinding.state!!.message)
            }
        }
    }

    private fun setWeatherDetails(weatherData: WeatherData?) {
        weatherData?.let {
            root.tv_city_name.text = it.name
            root.tv_main_temp.text = Utils.getTemperatureInCelsius(it.main!!.temp!!)
            root.tv_min_temp.text = Utils.getTemperatureInCelsius(it.main!!.tempMin!!)
            root.tv_max_temp.text = Utils.getTemperatureInCelsius(it.main!!.tempMax!!)
            root.tv_weahter_discription.text = Utils.formatDiscription(it.weather!![0]!!.description!!)
            Picasso.get().load(Utils.getImageUrl(it.weather!![0]!!.icon!!)).into(root.iv_large_weather_icon)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setWeatherForecastDetails(weatherForecastData: WeatherForecastData) {
        weatherForecastData.let {
            root.tv_day1.text = Utils.getDayFromDate(it.list!![0]!!.dtTxt!!)
            root.tv_min_max_temp1.text = Utils.getTemperatureInCelsiusSmall(it.list!![0]!!.main!!.tempMin!!) +
                    "/" + Utils.getTemperatureInCelsiusSmall(it.list!![0]!!.main!!.tempMax!!)
            Picasso.get().load(Utils.getImageUrl(it.list!![0]!!.weather!![0]!!.icon!!)).into(root.iv_small_weather_icon1)

            root.tv_day2.text = Utils.getDayFromDate(it.list!![8]!!.dtTxt!!)
            root.tv_min_max_temp2.text = Utils.getTemperatureInCelsiusSmall(it.list!![8]!!.main!!.tempMin!!) +
                    "/" + Utils.getTemperatureInCelsiusSmall(it.list!![8]!!.main!!.tempMax!!)
            Picasso.get().load(Utils.getImageUrl(it.list!![8]!!.weather!![0]!!.icon!!)).into(root.iv_small_weather_icon2)

            root.tv_day3.text = Utils.getDayFromDate(it.list!![16]!!.dtTxt!!)
            root.tv_min_max_temp3.text = Utils.getTemperatureInCelsiusSmall(it.list!![16]!!.main!!.tempMin!!) +
                    "/" + Utils.getTemperatureInCelsiusSmall(it.list!![16]!!.main!!.tempMax!!)
            Picasso.get().load(Utils.getImageUrl(it.list!![16]!!.weather!![0]!!.icon!!)).into(root.iv_small_weather_icon3)

            root.tv_day4.text = Utils.getDayFromDate(it.list!![24]!!.dtTxt!!)
            root.tv_min_max_temp4.text = Utils.getTemperatureInCelsiusSmall(it.list!![24]!!.main!!.tempMin!!) +
                    "/" + Utils.getTemperatureInCelsiusSmall(it.list!![24]!!.main!!.tempMax!!)
            Picasso.get().load(Utils.getImageUrl(it.list!![24]!!.weather!![0]!!.icon!!)).into(root.iv_small_weather_icon4)

            root.tv_day5.text = Utils.getDayFromDate(it.list!![32]!!.dtTxt!!)
            root.tv_min_max_temp5.text = Utils.getTemperatureInCelsiusSmall(it.list!![32]!!.main!!.tempMin!!) +
                    "/" + Utils.getTemperatureInCelsiusSmall(it.list!![32]!!.main!!.tempMax!!)
            Picasso.get().load(Utils.getImageUrl(it.list!![32]!!.weather!![0]!!.icon!!)).into(root.iv_small_weather_icon5)
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