package com.busra.weatherforecast.service

import com.busra.weatherforecast.model.Location
import com.busra.weatherforecast.model.WeatherCondition
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {

    @GET("search?")
    fun getLocation(@Query("lattlong")latt:Float, long : Float): Single<List<Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid")woeid:Int): Single<WeatherCondition>

}