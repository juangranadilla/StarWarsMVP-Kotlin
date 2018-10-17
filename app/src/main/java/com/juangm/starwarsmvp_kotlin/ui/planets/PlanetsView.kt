package com.juangm.starwarsmvp_kotlin.ui.planets

import com.juangm.starwarsmvp_kotlin.data.models.Planet
import com.juangm.starwarsmvp_kotlin.ui.common.BaseView

interface PlanetsView: BaseView {
    fun updatePlanetList(planets: List<Planet>, nextPage: Int?)
}