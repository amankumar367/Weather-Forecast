package com.android.aman.weatherforecast.api.data

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("base")
    var base: String?,
    @SerializedName("clouds")
    var clouds: Clouds?,
    @SerializedName("cod")
    var cod: Int?,
    @SerializedName("coord")
    var coord: Coord?,
    @SerializedName("dt")
    var dt: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("main")
    var main: Main?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("rain")
    var rain: Rain?,
    @SerializedName("sys")
    var sys: Sys?,
    @SerializedName("timezone")
    var timezone: Int?,
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

    data class Coord(
        @SerializedName("lat")
        var lat: Double?,
        @SerializedName("lon")
        var lon: Double?
    ):Serializable

    data class Clouds(
        @SerializedName("all")
        var all: Int?
    ):Serializable

    data class Wind(
        @SerializedName("deg")
        var deg: Double?,
        @SerializedName("speed")
        var speed: Double?
    ):Serializable

    data class Sys(
        @SerializedName("country")
        var country: String?,
        @SerializedName("message")
        var message: Double?,
        @SerializedName("sunrise")
        var sunrise: Int?,
        @SerializedName("sunset")
        var sunset: Int?
    ):Serializable

    data class Rain(
        @SerializedName("3h")
        var h: Double?
    ) : Serializable

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
        @SerializedName("temp_max")
        var tempMax: Double?,
        @SerializedName("temp_min")
        var tempMin: Double?
    ) : Serializable
}