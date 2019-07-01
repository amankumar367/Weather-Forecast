package com.android.aman.weatherforecast.api.repo

import com.android.aman.weatherforecast.Utils
import com.android.aman.weatherforecast.api.data.WeatherData
import com.android.aman.weatherforecast.api.data.WeatherForecastData
import com.android.aman.weatherforecast.api.retrofit.ApiCallBack
import com.android.aman.weatherforecast.api.retrofit.ApiInterface
import com.android.aman.weatherforecast.app.MainApplication
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class WeatherForecastRepo(private var cityName: String?) : WeatherForecastRepoI {
    @Inject
    lateinit var mRetrofit: Retrofit

    private var weatherApi: ApiInterface? = null
    init {
        MainApplication.getAppComponent()!!.inject(this)
        weatherApi = mRetrofit.create(ApiInterface::class.java)
    }

    override fun getWeather(apiCallBack: ApiCallBack<WeatherData>) {
        weatherApi!!.getWeatherDetails(city = cityName!!,appId = Utils.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherData>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: WeatherData) {
                    apiCallBack.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    apiCallBack.onFailure(e.localizedMessage)
                }
            })
    }

    override fun getWeatherForecast(apiCallBack: ApiCallBack<WeatherForecastData>) {
        weatherApi!!.getWeatherForecastDetails(city = cityName!!, appId = Utils.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherForecastData>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: WeatherForecastData) {
                    apiCallBack.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    apiCallBack.onFailure(e.localizedMessage)
                }
            })
    }
}
