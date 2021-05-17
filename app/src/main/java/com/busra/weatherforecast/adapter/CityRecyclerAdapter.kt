package com.busra.weatherforecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.busra.weatherforecast.R
import com.busra.weatherforecast.model.WeatherCondition
import com.busra.weatherforecast.view.CitiesFragmentArgs
import com.busra.weatherforecast.view.CitiesFragmentDirections
import kotlinx.android.synthetic.main.fragment_weather.view.*

class CityRecyclerAdapter (val weatherList: List<WeatherCondition>):
    RecyclerView.Adapter<CityRecyclerAdapter.CityViewHolder>() {
    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.city_recycler_row,parent,false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        //görsel eklenecek
        holder.itemView.cityName.text = weatherList.get(position).title
        holder.itemView.degree.text = weatherList.get(position).the_temp.toString()

        holder.itemView.setOnClickListener(){
            val action = CitiesFragmentDirections.actionCitiesFragmentToWeatherFragment(0)
            Navigation.findNavController(it).navigate(action)
        }
    }
}