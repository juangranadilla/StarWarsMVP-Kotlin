package com.juangm.starwarsmvp_kotlin.ui.characters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R
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

    override fun showProgress() {
        progress_characters.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_characters.visibility = View.GONE
    }

    override fun showCharacterList() {
        toast("Success loading characters!")
    }

    override fun showError() {
        toast("Error loading characters...")
    }
}
