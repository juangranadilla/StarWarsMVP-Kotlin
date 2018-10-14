package com.juangm.starwarsmvp_kotlin.ui.characters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.models.Character
import com.juangm.starwarsmvp_kotlin.ui.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_characters.*
import org.jetbrains.anko.support.v4.toast

class CharactersFragment : Fragment(), CharactersView {

    private val charactersPresenter : CharactersPresenter = CharactersPresenter(this, CharactersInteractor())
    private var characters: MutableList<Character> = ArrayList<Character>()
    private var nextPage: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onStart() {
        super.onStart()
        setAdapter(rv_characters, characters)
        charactersPresenter.loadCharacters(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        charactersPresenter.onDestroy()
    }

    fun setAdapter(recyclerView: RecyclerView, characters: List<Character>) {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = CharactersAdapter(characters, context)
        recyclerView.addOnScrollListener(InfiniteScrollListener({ loadMore() }, linearLayoutManager))
    }

    fun loadMore() {
        charactersPresenter.loadCharacters(nextPage)
    }

    override fun showProgress() {
        progress_characters.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_characters.visibility = View.GONE
    }

    override fun showProgressLoadMore() {
        progress_characters_load_more.visibility = View.VISIBLE
    }

    override fun hideProgressLoadMore() {
        progress_characters_load_more.visibility = View.GONE
    }

    override fun updateCharacterList(characters: List<Character>, nextPage: Int?) {
        this.characters.addAll(characters)
        rv_characters.adapter?.notifyDataSetChanged()
        this.nextPage = nextPage
    }

    override fun showError() {
        toast("Error loading characters...")
    }
}
