package com.android.aman.weatherforecast.di.components

import com.android.aman.weatherforecast.app.MainApplication
import com.android.aman.weatherforecast.di.modules.ApplicationModule
import com.android.aman.weatherforecast.di.modules.NetworkModule

class ComponentFactory {
    companion object{
        fun create(application: MainApplication): AppComponent {
            return DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(application))
                .networkModule(NetworkModule())
                .build()
        }
    }
}