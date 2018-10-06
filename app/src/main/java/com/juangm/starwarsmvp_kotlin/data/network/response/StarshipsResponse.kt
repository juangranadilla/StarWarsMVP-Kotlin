package com.juangm.starwarsmvp_kotlin.data.network.response

import com.juangm.starwarsmvp_kotlin.data.models.Starship
import java.util.ArrayList

class StarshipsResponse {
    var count: Int? = null
    var next: String? = null
    var previous: String? = null
    var results: List<Starship>? = ArrayList()
}