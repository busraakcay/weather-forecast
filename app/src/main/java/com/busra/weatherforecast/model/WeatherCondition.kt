package com.busra.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class WeatherCondition (
    @SerializedName("title")
    val title : String?,
    @SerializedName("weather_state_abbr")
    val weather_state_abbr : String?,
    @SerializedName("the_temp")
    val the_temp : Double?
){
}