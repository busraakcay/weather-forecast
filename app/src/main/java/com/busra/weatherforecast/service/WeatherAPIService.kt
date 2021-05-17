package com.busra.weatherforecast.service

import com.busra.weatherforecast.model.Location
import com.busra.weatherforecast.model.WeatherCondition
import com.busra.weatherforecast.view.MainActivity
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherAPIService {
    var mainActivity = MainActivity()
    private val BASE_URL = "https://www.metaweather.com/api/location/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    fun getDataLocation() : Single<List<Location>> {
        return api.getLocation(mainActivity.sendLatt(), mainActivity.sendLong())
    }

    fun getDataWeather() : Single<WeatherCondition> {
        return api.getWeather(0) // will added woeid from city-location api
    }

}