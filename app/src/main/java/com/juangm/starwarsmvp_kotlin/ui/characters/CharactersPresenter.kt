package com.juangm.starwarsmvp_kotlin.ui.characters

class CharactersPresenter(var charactersView: CharactersView?, var charactersInteractor: CharactersInteractor) : CharactersInteractor.onLoadCharacters {

    fun loadCharacters() {
        charactersView?.showProgress()
        charactersInteractor.getCharacters(this)
    }

    fun onDestroy() {
        charactersView = null
    }

    override fun onLoadCharactersSuccess() {
        charactersView?.hideProgress()
        charactersView?.showCharacterList()
    }

    override fun onLoadCharactersError() {
        charactersView?.hideProgress()
        charactersView?.showError()
    }
}