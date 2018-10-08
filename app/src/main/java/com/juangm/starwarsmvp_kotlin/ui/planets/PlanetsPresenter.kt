package com.juangm.starwarsmvp_kotlin.ui.planets

class PlanetsPresenter(var planetsView: PlanetsView?, var planetsInteractor: PlanetsInteractor) : PlanetsInteractor.onLoadPlanets {

    fun loadPlanets() {
        planetsInteractor.getPlanets(this)
    }

    fun onDestroy() {
        planetsView = null
    }

    override fun onLoadPlanetsSuccess() {
        planetsView?.hideProgress()
        planetsView?.showPlanetList()
    }

    override fun onLoadPlanetsError() {
        planetsView?.hideProgress()
        planetsView?.showError()
    }
}