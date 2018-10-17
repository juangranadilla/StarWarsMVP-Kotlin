package com.juangm.starwarsmvp_kotlin.ui.starships

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.models.Starship
import com.juangm.starwarsmvp_kotlin.ui.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_starships.*
import org.jetbrains.anko.support.v4.toast

class StarshipsFragment : Fragment(), StarshipsView {

    private val starshipsPresenter : StarshipsPresenter = StarshipsPresenter(this, StarshipsInteractor())
    private var starships: MutableList<Starship> = ArrayList()
    private var nextPage: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starships, container, false)
    }

    override fun onStart() {
        super.onStart()
        setAdapter(rv_starships, starships)
        starshipsPresenter.loadStarships(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        starshipsPresenter.onDestroy()
    }

    fun setAdapter(recyclerView: RecyclerView, starships: List<Starship>) {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = StarshipsAdapter(starships, context)
        recyclerView.addOnScrollListener(InfiniteScrollListener({ loadMore() }, linearLayoutManager))
    }

    fun loadMore() {
        starshipsPresenter.loadStarships(nextPage)
    }

    override fun showProgress() {
        progress_starships.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_starships.visibility = View.GONE
    }

    override fun showProgressLoadMore() {
        progress_starships_load_more.visibility = View.VISIBLE
    }

    override fun hideProgressLoadMore() {
        progress_starships_load_more.visibility = View.GONE
    }

    override fun showStarshipList(starships: List<Starship>, nextPage: Int?) {
        this.starships.addAll(starships)
        rv_starships.adapter?.notifyDataSetChanged()
        this.nextPage = nextPage
    }

    override fun showError() {
        toast("Success loading starships!")
    }
}
