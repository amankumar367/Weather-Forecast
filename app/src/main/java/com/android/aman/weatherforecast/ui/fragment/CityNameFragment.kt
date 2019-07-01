package com.android.aman.weatherforecast.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aman.weatherforecast.R
import kotlinx.android.synthetic.main.fragment_city_name.view.*

class CityNameFragment : Fragment() {

    private lateinit var root : View
    private val fragmentWeatherForecastFragment = WeatherForecastFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_city_name, container, false)
        onClick()
        return root
    }

    private fun onClick() {
        root.openWeatherForecast.setOnClickListener{
            startFragment()
        }
    }

    private fun startFragment() {
        fragmentManager!!.beginTransaction().replace(R.id.mainActivity, fragmentWeatherForecastFragment).commit()
    }
}