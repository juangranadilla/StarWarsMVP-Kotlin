package com.juangm.starwarsmvp_kotlin.data.network.response

import com.juangm.starwarsmvp_kotlin.data.models.Planet
import java.util.ArrayList

class PlanetsResponse {
    var count: Int? = null
    var next: String? = null
    var previous: String? = null
    var results: List<Planet>? = ArrayList()
}