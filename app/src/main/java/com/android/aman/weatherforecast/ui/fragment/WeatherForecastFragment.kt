package com.android.aman.weatherforecast.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aman.weatherforecast.R

class WeatherForecastFragment : Fragment() {

    private lateinit var root : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_weather_forecast, container, false)
        return root
    }
}