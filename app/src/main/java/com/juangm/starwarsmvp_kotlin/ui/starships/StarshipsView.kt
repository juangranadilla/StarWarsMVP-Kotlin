package com.juangm.starwarsmvp_kotlin.ui.starships

interface StarshipsView {
    fun showProgress()
    fun hideProgress()
    fun showStarshipList()
    fun showError()
}