package com.busra.weatherforecast.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.busra.weatherforecast.model.Location
import com.busra.weatherforecast.model.WeatherCondition
import com.busra.weatherforecast.service.WeatherAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CitiesViewModel : ViewModel(){
    val location = MutableLiveData<List<Location>>()
    val citiesError = MutableLiveData<Boolean>()
    val citiesLoading = MutableLiveData<Boolean>()

    private val weatherAPIService = WeatherAPIService()
    private val disposable = CompositeDisposable()

    // nearby cities api -

    fun refreshData(){
        getWeatherConditions()
    }

    fun getWeatherConditions(){
        citiesLoading.value = true

        disposable.add(
            weatherAPIService.getDataLocation()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Location>>(){
                    override fun onSuccess(t: List<Location>){
                        location.value = t
                        citiesLoading.value = false
                        citiesError.value = false
                    }

                    override fun onError(e: Throwable){
                        citiesLoading.value = false
                        citiesError.value = true
                        e.printStackTrace()
                    }

                    //swipeRefreshLayout -
                    //weather view model api -


                })
        )
    }

}