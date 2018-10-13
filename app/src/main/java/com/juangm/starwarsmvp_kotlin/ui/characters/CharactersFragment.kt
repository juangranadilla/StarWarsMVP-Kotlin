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
import kotlinx.android.synthetic.main.fragment_characters.*
import org.jetbrains.anko.support.v4.toast

class CharactersFragment : Fragment(), CharactersView {

    private val charactersPresenter : CharactersPresenter = CharactersPresenter(this, CharactersInteractor())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onStart() {
        super.onStart()
        charactersPresenter.loadCharacters()
    }

    override fun onDestroy() {
        super.onDestroy()
        charactersPresenter.onDestroy()
    }

    fun setAdapter(recyclerView: RecyclerView, characters: List<Character>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CharactersAdapter(characters, context)
    }

    override fun showProgress() {
        progress_characters.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_characters.visibility = View.GONE
    }

    override fun showCharacterList(characters: List<Character>) {
        setAdapter(rv_characters, characters)
    }

    override fun showError() {
        toast("Error loading characters...")
    }
}
