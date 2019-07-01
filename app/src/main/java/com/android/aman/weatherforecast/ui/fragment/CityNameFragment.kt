package com.android.aman.weatherforecast.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.aman.weatherforecast.R
import kotlinx.android.synthetic.main.fragment_city_name.view.*

class CityNameFragment : Fragment() {

    private lateinit var root : View
    private lateinit var cityName : String
    private val fragmentWeatherForecastFragment = WeatherForecastFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_city_name, container, false)
        getCityName()
        onClick()
        return root
    }

    private fun onClick() {
        root.openWeatherForecast.setOnClickListener{
            if(getCityName() != null){
                startFragment(getCityName())
            }
        }
    }

    private fun startFragment(cityName: String?) {
        val bundle = Bundle()
        bundle.putString(WeatherForecastFragment.CITY_NAME, cityName)

        fragmentWeatherForecastFragment.arguments = bundle
        fragmentManager!!.beginTransaction().replace(R.id.mainActivity, fragmentWeatherForecastFragment).commit()
    }

    private fun getCityName() : String? {
        cityName = root.enter_city_name.text.toString()
        if(cityName.isEmpty()){
            Toast.makeText(root.context,"Enter valid city name",Toast.LENGTH_SHORT).show()
            return null
        }
        return  cityName
    }
}
