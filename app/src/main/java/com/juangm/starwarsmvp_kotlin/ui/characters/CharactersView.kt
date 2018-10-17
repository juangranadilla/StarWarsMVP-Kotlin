package com.juangm.starwarsmvp_kotlin.ui.characters

import com.juangm.starwarsmvp_kotlin.data.models.Character
import com.juangm.starwarsmvp_kotlin.ui.common.BaseView

interface CharactersView: BaseView {
    fun updateCharacterList(characters: List<Character>, nextPage: Int?)
}