package com.busra.weatherforecast.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.busra.weatherforecast.model.Location
import com.busra.weatherforecast.model.WeatherCondition

class WeatherViewModel : ViewModel() {
    val weather = MutableLiveData<List<WeatherCondition>>()
    val weatherLiveData = MutableLiveData<WeatherCondition>()

    // weather forecast api -
}