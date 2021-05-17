package com.busra.weatherforecast.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.busra.weatherforecast.R
import com.google.android.gms.maps.model.LatLng
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var locationManager : LocationManager
    private lateinit var locationListener : LocationListener
    private lateinit var cityName : String
    private var lat : Float = 0.0f
    private var lng : Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        location()
        sendLatt()
        sendLong()
    }
    fun location(){
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener{
            override fun onLocationChanged(location: Location) {
                val geocoder = Geocoder(this@MainActivity, Locale.getDefault())
                try{
                    val addresses = geocoder.getFromLocation(location.latitude,location.longitude,1)
                    lat = location.latitude.toFloat()
                    lng = location.longitude.toFloat()
                    cityName = addresses.get(0).adminArea.toString()
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1f,locationListener)
            val lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (lastLocation != null) {
                val newLastLocation = LatLng(lastLocation.latitude,lastLocation.longitude)
            }
        }
    }
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {

        if (requestCode == 1){
            if (grantResults.isNotEmpty()){
                if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1f,locationListener)

                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun sendLatt() : Float{
        return lat
    }
    fun sendLong() : Float{
        return lng
    }

}