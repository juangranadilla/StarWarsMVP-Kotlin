package com.juangm.starwarsmvp_kotlin.ui.starships

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.models.Starship
import kotlinx.android.synthetic.main.item_starship.view.*

class StarshipsAdapter(var starships: List<Starship>, var context: Context) : RecyclerView.Adapter<StarshipsAdapter.StarshipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StarshipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_starship, parent, false)
        return StarshipViewHolder(view)
    }

    override fun getItemCount(): Int {
        return starships.size
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {
        holder.bindItems(starships.get(position))
    }

    class StarshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(starship: Starship) {
            itemView.tv_starship_name.text = starship.name
            itemView.tv_starship_model.text = starship.model
            itemView.tv_starship_hyperdrive_rating.text = starship.hyperdrive_rating
        }
    }
}