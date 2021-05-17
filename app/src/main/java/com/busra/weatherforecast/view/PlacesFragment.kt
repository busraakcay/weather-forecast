package com.busra.weatherforecast.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.media.AudioAttributesCompat.fromBundle
import androidx.navigation.Navigation
import com.busra.weatherforecast.R
import com.busra.weatherforecast.adapter.PlaceRecyclerAdapter
import com.busra.weatherforecast.viewmodel.PlacesViewModel
import kotlinx.android.synthetic.main.fragment_places.*

class PlacesFragment : Fragment() {
    var mainActivity = MainActivity()
    private lateinit var viewModel : PlacesViewModel
    //private val placeRecyclerAdapter = PlaceRecyclerAdapter(woeid)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goNearbyCities.setOnClickListener {
            val action = PlacesFragmentDirections.actionPlacesFragmentToCitiesFragment(mainActivity.sendLatt(), mainActivity.sendLong())
            Navigation.findNavController(it).navigate(action)
        }

        viewModel = ViewModelProviders.of(this).get(PlacesViewModel::class.java)
    }

}