package com.busra.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("woeid")
    val woeid : Int?
) {
}