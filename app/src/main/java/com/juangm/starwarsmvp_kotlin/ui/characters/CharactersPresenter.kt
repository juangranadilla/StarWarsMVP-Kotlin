package com.juangm.starwarsmvp_kotlin.ui.characters

import com.juangm.starwarsmvp_kotlin.data.models.Character

class CharactersPresenter(var charactersView: CharactersView?, var charactersInteractor: CharactersInteractor) : CharactersInteractor.onLoadCharacters {

    fun loadCharacters() {
        charactersView?.showProgress()
        charactersInteractor.getCharacters(this)
    }

    fun onDestroy() {
        charactersView = null
    }

    override fun onLoadCharactersSuccess(characters: List<Character>?) {
        charactersView?.hideProgress()
        if(characters != null) {
            charactersView?.showCharacterList(characters)
        } else {
            onLoadCharactersError()
        }
    }

    override fun onLoadCharactersError() {
        charactersView?.hideProgress()
        charactersView?.showError()
    }
}