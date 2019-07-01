package com.android.aman.weatherforecast.api.retrofit

interface ApiCallBack<T> {
    fun onSuccess(t: T)
    fun onFailure(message: String)
}