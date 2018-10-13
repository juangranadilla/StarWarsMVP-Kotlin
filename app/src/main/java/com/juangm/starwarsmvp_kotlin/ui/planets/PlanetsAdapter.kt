package com.juangm.starwarsmvp_kotlin.ui.planets

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.models.Planet
import kotlinx.android.synthetic.main.item_planet.view.*

class PlanetsAdapter(var planets: List<Planet>, var context: Context) : RecyclerView.Adapter<PlanetsAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        return PlanetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.bindItems(planets.get(position))
    }

    class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(planet : Planet) {
            itemView.tv_planet_name.text = planet.name
            itemView.tv_planet_climate.text = planet.climate
            itemView.tv_planet_terrain.text = planet.terrain
        }
    }
}