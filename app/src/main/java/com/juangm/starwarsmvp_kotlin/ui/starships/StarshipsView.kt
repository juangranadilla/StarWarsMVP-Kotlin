package com.juangm.starwarsmvp_kotlin.ui.starships

import com.juangm.starwarsmvp_kotlin.data.models.Starship
import com.juangm.starwarsmvp_kotlin.ui.common.BaseView

interface StarshipsView: BaseView {
    fun showStarshipList(starships: List<Starship>, nextPage: Int?)
}