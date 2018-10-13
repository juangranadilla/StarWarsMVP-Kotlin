package com.juangm.starwarsmvp_kotlin.ui.characters

import com.juangm.starwarsmvp_kotlin.data.models.Character

interface CharactersView {
    fun showProgress()
    fun hideProgress()
    fun showCharacterList(characters: List<Character>)
    fun showError()
}