package com.juangm.starwarsmvp_kotlin.ui.planets

import com.juangm.starwarsmvp_kotlin.data.models.Planet

class PlanetsPresenter(var planetsView: PlanetsView?, var planetsInteractor: PlanetsInteractor) : PlanetsInteractor.onLoadPlanets {

    fun loadPlanets(nextPage: Int?) {
        if(nextPage != null) {
            if(nextPage == 1) {
                planetsView?.showProgress()
            } else {
                planetsView?.showProgressLoadMore()
            }
            planetsInteractor.getPlanets(this, nextPage)
        }
    }

    fun onDestroy() {
        planetsView = null
    }

    override fun onLoadPlanetsSuccess(planets: List<Planet>?, nextPage: Int?) {
        planetsView?.hideProgress()
        planetsView?.hideProgressLoadMore()
        if(planets != null) {
            planetsView?.updatePlanetList(planets, nextPage)
        } else {
            onLoadPlanetsError()
        }
    }

    override fun onLoadPlanetsError() {
        planetsView?.hideProgress()
        planetsView?.hideProgressLoadMore()
        planetsView?.showError()
    }
}