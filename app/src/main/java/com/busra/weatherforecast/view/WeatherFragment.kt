package com.busra.weatherforecast.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.busra.weatherforecast.R
import com.busra.weatherforecast.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_weather.*

class WeatherFragment : Fragment() {

    private lateinit var viewModel : WeatherViewModel
    private var cityId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        arguments?.let {
            cityId = WeatherFragmentArgs.fromBundle(it).cityId
        }
        observeLiveData()
    }

    fun observeLiveData(){
        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer { weather ->
            weather?.let {
                cityName.text = it.title
                degree.text = it.the_temp.toString()
            }
        })
    }

}