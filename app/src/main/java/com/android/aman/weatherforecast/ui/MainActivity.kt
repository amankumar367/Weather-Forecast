package com.android.aman.weatherforecast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.aman.weatherforecast.R
import com.android.aman.weatherforecast.ui.fragment.CityNameFragment
import com.android.aman.weatherforecast.ui.fragment.WeatherForecastFragment

class MainActivity : AppCompatActivity() {

    private val fragmentCityNameFragment = CityNameFragment()
    private val fragmentWeatherForecastFragment = WeatherForecastFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startFragment()
    }

    private fun startFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.mainActivity, fragmentCityNameFragment).commit()
    }
}
