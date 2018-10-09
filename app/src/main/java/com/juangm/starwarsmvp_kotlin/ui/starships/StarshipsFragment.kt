package com.juangm.starwarsmvp_kotlin.ui.starships

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import kotlinx.android.synthetic.main.fragment_starships.*
import org.jetbrains.anko.support.v4.toast

class StarshipsFragment : Fragment(), StarshipsView {

    private val starshipsPresenter : StarshipsPresenter = StarshipsPresenter(this, StarshipsInteractor())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starships, container, false)
    }

    override fun onStart() {
        super.onStart()
        starshipsPresenter.loadCharacters()
    }

    override fun onDestroy() {
        super.onDestroy()
        starshipsPresenter.onDestroy()
    }

    override fun showProgress() {
        progress_starships.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_starships.visibility = View.GONE
    }

    override fun showStarshipList() {
        toast("Success loading starships!")
    }

    override fun showError() {
        toast("Success loading starships!")
    }
}
