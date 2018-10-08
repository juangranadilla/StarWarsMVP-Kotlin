package com.juangm.starwarsmvp_kotlin.ui.planets

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import kotlinx.android.synthetic.main.fragment_planets.*
import org.jetbrains.anko.support.v4.toast

class PlanetsFragment : Fragment(), PlanetsView {

    private val planetsPresenter : PlanetsPresenter = PlanetsPresenter(this, PlanetsInteractor())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_planets, container, false)

        planetsPresenter.loadPlanets()

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        planetsPresenter.onDestroy()
    }

    override fun showProgress() {
        progress_planets.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_planets.visibility = View.GONE
    }

    override fun showPlanetList() {
        toast("Success!")
    }

    override fun showError() {
        toast("Error")
    }
}
