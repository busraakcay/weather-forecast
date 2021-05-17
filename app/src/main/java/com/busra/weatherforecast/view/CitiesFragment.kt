package com.busra.weatherforecast.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.busra.weatherforecast.R
import com.busra.weatherforecast.adapter.CityRecyclerAdapter
import com.busra.weatherforecast.viewmodel.CitiesViewModel

class CitiesFragment : Fragment() {
    private lateinit var viewModel: CitiesViewModel
    private  val cityRecyclerAdapter = CityRecyclerAdapter(arrayListOf()) // not yet
    private var lat = 0.0f
    private var lng = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CitiesViewModel::class.java)


    }
}