package com.juangm.starwarsmvp_kotlin.ui.planets

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.models.Planet
import com.juangm.starwarsmvp_kotlin.ui.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_planets.*
import org.jetbrains.anko.support.v4.toast

class PlanetsFragment : Fragment(), PlanetsView {

    private val planetsPresenter : PlanetsPresenter = PlanetsPresenter(this, PlanetsInteractor())
    private var planets: MutableList<Planet> = ArrayList()
    private var nextPage: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onStart() {
        super.onStart()
        setAdapter(rv_planets, planets)
        planetsPresenter.loadPlanets(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        planetsPresenter.onDestroy()
    }

    fun setAdapter(recyclerView: RecyclerView, planets: List<Planet>) {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = PlanetsAdapter(planets, context)
        recyclerView.addOnScrollListener(InfiniteScrollListener({ loadMore() }, linearLayoutManager))
    }

    fun loadMore() {
        planetsPresenter.loadPlanets(nextPage)
    }

    override fun showProgress() {
        progress_planets.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_planets.visibility = View.GONE
    }

    override fun showProgressLoadMore() {
        progress_planets_load_more.visibility = View.VISIBLE
    }

    override fun hideProgressLoadMore() {
        progress_planets_load_more.visibility = View.GONE
    }

    override fun updatePlanetList(planets: List<Planet>, nextPage: Int?) {
        this.planets.addAll(planets)
        rv_planets.adapter?.notifyDataSetChanged()
        this.nextPage = nextPage
    }

    override fun showError() {
        toast("Error loading planets...")
    }
}
