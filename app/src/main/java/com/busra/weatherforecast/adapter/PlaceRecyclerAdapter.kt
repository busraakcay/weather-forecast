package com.busra.weatherforecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busra.weatherforecast.R
import com.busra.weatherforecast.model.Location
import kotlinx.android.synthetic.main.fragment_places.view.*

class PlaceRecyclerAdapter (val locationList: List<Location>):
    RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder>() {
    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.place_recycler_row,parent,false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  locationList.size
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.itemView.placesRecycler

    }
}