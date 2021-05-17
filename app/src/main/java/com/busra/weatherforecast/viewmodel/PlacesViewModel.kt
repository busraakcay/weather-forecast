package com.busra.weatherforecast.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.busra.weatherforecast.model.Location

class PlacesViewModel : ViewModel() {

    val placesError = MutableLiveData<Boolean>()
    val placesLoading = MutableLiveData<Boolean>()

    // nearby places api -
}