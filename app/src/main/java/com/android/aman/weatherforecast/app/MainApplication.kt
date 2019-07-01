package com.android.aman.weatherforecast.app

import android.app.Application
import com.android.aman.weatherforecast.di.components.AppComponent
import com.android.aman.weatherforecast.di.components.ComponentFactory

class MainApplication : Application() {

    companion object{
        private lateinit var appContext: Application
        private var appComponent: AppComponent? = null

        fun getAppComponent(): AppComponent? {
            return appComponent
        }

        fun getAppContext(): Application {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        createComponent()
    }

    private fun createComponent() {
        if (appComponent == null) {
            appComponent = ComponentFactory.create(this)
        }
    }

    fun getAppComponent(): AppComponent? {
        return appComponent
    }

    fun getAppContext(): Application {
        return appContext
    }
}