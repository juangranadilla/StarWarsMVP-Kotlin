package com.juangm.starwarsmvp_kotlin.ui.planets

interface PlanetsView {
    fun showProgress()
    fun hideProgress()
    fun showPlanetList()
    fun showError()
}