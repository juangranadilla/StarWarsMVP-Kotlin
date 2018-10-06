package com.juangm.starwarsmvp_kotlin.data.network.response

import com.juangm.starwarsmvp_kotlin.data.models.Character
import java.util.ArrayList

class CharactersResponse {
    var count: Int? = null
    var next: String? = null
    var previous: String? = null
    var results: List<Character>? = ArrayList()
}