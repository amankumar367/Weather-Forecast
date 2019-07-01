package com.android.aman.weatherforecast.api.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherForecastData(
    @SerializedName("city")
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<X?>?,
    @SerializedName("message")
    var message: Double?
):Serializable {
    data class City(
        @SerializedName("coord")
        var coord: Coord?,
        @SerializedName("country")
        var country: String?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("population")
        var population: Int?,
        @SerializedName("timezone")
        var timezone: Int?
    ):Serializable {
        data class Coord(
            @SerializedName("lat")
            var lat: Double?,
            @SerializedName("lon")
            var lon: Double?
        ):Serializable
    }

    data class X(
        @SerializedName("clouds")
        var clouds: Clouds?,
        @SerializedName("dt")
        var dt: Int?,
        @SerializedName("dt_txt")
        var dtTxt: String?,
        @SerializedName("main")
        var main: Main?,
        @SerializedName("rain")
        var rain: Rain?,
        @SerializedName("sys")
        var sys: Sys?,
        @SerializedName("weather")
        var weather: List<Weather?>?,
        @SerializedName("wind")
        var wind: Wind?
    ):Serializable {
        data class Weather(
            @SerializedName("description")
            var description: String?,
            @SerializedName("icon")
            var icon: String?,
            @SerializedName("id")
            var id: Int?,
            @SerializedName("main")
            var main: String?
        ):Serializable

        data class Clouds(
            @SerializedName("all")
            var all: Int?
        ):Serializable

        data class Sys(
            @SerializedName("pod")
            var pod: String?
        ):Serializable

        data class Wind(
            @SerializedName("deg")
            var deg: Double?,
            @SerializedName("speed")
            var speed: Double?
        ):Serializable

        data class Rain(
            @SerializedName("3h")
            var h: Double?
        ):Serializable

        data class Main(
            @SerializedName("grnd_level")
            var grndLevel: Double?,
            @SerializedName("humidity")
            var humidity: Int?,
            @SerializedName("pressure")
            var pressure: Double?,
            @SerializedName("sea_level")
            var seaLevel: Double?,
            @SerializedName("temp")
            var temp: Double?,
            @SerializedName("temp_kf")
            var tempKf: Double?,
            @SerializedName("temp_max")
            var tempMax: Double?,
            @SerializedName("temp_min")
            var tempMin: Double?
        ):Serializable
    }
}