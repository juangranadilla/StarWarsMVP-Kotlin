package com.juangm.starwarsmvp_kotlin.ui.characters

interface CharactersView {
    fun showProgress()
    fun hideProgress()
    fun showCharacterList()
    fun showError()
}