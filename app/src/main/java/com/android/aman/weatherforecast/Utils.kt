package com.android.aman.weatherforecast

import android.annotation.SuppressLint
import java.text.DecimalFormat
import java.text.SimpleDateFormat

object Utils {
    const val API_KEY = "ca6c090ada249f4bec0af5bbb9bfb048"

    fun getTemperatureInCelsius(temp: Double) : String{
        val tempCelsius = temp - 273.15
        return DecimalFormat("##.#").format(tempCelsius).toString()
    }

    fun getTemperatureInCelsiusSmall(temp: Double) : String{
        val tempCelsius = temp - 273.15
        return DecimalFormat("##").format(tempCelsius).toString()
    }

    fun formatDiscription(string: String) : String{
        val stringArray = string.split(" ")
        val builder = StringBuilder()
        for (s in stringArray) {
            val cap = s.substring(0, 1).toUpperCase() + s.substring(1)
            builder.append("$cap ")
        }
        return builder.toString()
     }

    fun getImageUrl(icon: String): String {
        return String.format("http://openweathermap.org/img/w/%s.png", icon)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDate(date: String):String{
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = format1.parse(date)
        val format2 = SimpleDateFormat("EEEE")
        var result = format2.format(date)
        when (result) {
            "Sunday"    -> result = "Sun"
            "Monday"    -> result = "Mon"
            "Tuesday"   -> result = "Tue"
            "Wednesday" -> result = "Wed"
            "Thursday"  -> result = "Thu"
            "Friday"    -> result = "Fri"
            "Saturday"  -> result = "Sat"
        }
        return result
    }
}