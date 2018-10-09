package com.juangm.starwarsmvp_kotlin.ui.starships

class StarshipsPresenter(var starshipsView: StarshipsView?, var starshipsInteractor: StarshipsInteractor) : StarshipsInteractor.onLoadStarships {

    fun loadCharacters() {
        starshipsView?.showProgress()
        starshipsInteractor.getStarships(this)
    }

    fun onDestroy() {
        starshipsView = null
    }

    override fun onLoadStarshipsSuccess() {
        starshipsView?.hideProgress()
        starshipsView?.showStarshipList()
    }

    override fun onLoadStarshipsError() {
        starshipsView?.hideProgress()
        starshipsView?.showError()
    }
}