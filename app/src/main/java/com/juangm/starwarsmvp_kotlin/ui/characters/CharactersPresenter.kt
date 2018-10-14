package com.juangm.starwarsmvp_kotlin.ui.characters

import com.juangm.starwarsmvp_kotlin.data.models.Character

class CharactersPresenter(var charactersView: CharactersView?, var charactersInteractor: CharactersInteractor) : CharactersInteractor.onLoadCharacters {

    fun loadCharacters(nextPage: Int?) {
        if(nextPage != null) {
            charactersView?.showProgressLoadMore()
            charactersInteractor.getCharacters(this, nextPage)
        }
    }

    fun onDestroy() {
        charactersView = null
    }

    override fun onLoadCharactersSuccess(characters: List<Character>?, nextPage: Int?) {
        charactersView?.hideProgress()
        charactersView?.hideProgressLoadMore()
        if(characters != null) {
            charactersView?.updateCharacterList(characters, nextPage)
        } else {
            onLoadCharactersError()
        }
    }

    override fun onLoadCharactersError() {
        charactersView?.hideProgress()
        charactersView?.showError()
    }
}