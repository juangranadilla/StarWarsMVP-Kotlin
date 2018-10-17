package com.juangm.starwarsmvp_kotlin.ui.starships

import com.juangm.starwarsmvp_kotlin.data.models.Starship

class StarshipsPresenter(var starshipsView: StarshipsView?, var starshipsInteractor: StarshipsInteractor) : StarshipsInteractor.onLoadStarships {

    fun loadStarships(nextPage: Int?) {
        if(nextPage != null) {
            if(nextPage == 1) {
                starshipsView?.showProgress()
            } else {
                starshipsView?.showProgressLoadMore()
            }
            starshipsInteractor.getStarships(this, nextPage)
        }
    }

    fun onDestroy() {
        starshipsView = null
    }

    override fun onLoadStarshipsSuccess(starships: List<Starship>?, nextPage: Int?) {
        starshipsView?.hideProgress()
        starshipsView?.hideProgressLoadMore()
        if(starships != null) {
            starshipsView?.showStarshipList(starships, nextPage)
        } else {
            onLoadStarshipsError()
        }
    }

    override fun onLoadStarshipsError() {
        starshipsView?.hideProgress()
        starshipsView?.hideProgressLoadMore()
        starshipsView?.showError()
    }
}