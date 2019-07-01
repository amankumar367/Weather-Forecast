package com.android.aman.weatherforecast.di.components

import com.android.aman.weatherforecast.api.repo.WeatherForecastRepo
import com.android.aman.weatherforecast.di.modules.ApplicationModule
import com.android.aman.weatherforecast.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class])
interface AppComponent {
    fun inject(weatherForecastRepo : WeatherForecastRepo)
}