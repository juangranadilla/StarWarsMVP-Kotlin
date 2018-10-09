package com.juangm.starwarsmvp_kotlin.ui.planets

import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.PlanetsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetsInteractor {

    interface onLoadPlanets {
        fun onLoadPlanetsSuccess()
        fun onLoadPlanetsError()
    }

    fun getPlanets(onLoadPlanets: onLoadPlanets) {
        RetrofitClient.service.getPlanets().enqueue(object : Callback<PlanetsResponse> {
            override fun onFailure(call: Call<PlanetsResponse>, t: Throwable) {
                onLoadPlanets.onLoadPlanetsError()
            }

            override fun onResponse(call: Call<PlanetsResponse>, response: Response<PlanetsResponse>) {
                onLoadPlanets.onLoadPlanetsSuccess()
            }
        })
    }
}