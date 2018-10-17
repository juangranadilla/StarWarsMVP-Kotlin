package com.juangm.starwarsmvp_kotlin.ui.planets

import android.net.Uri
import com.juangm.starwarsmvp_kotlin.data.models.Planet
import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.PlanetsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetsInteractor {

    interface onLoadPlanets {
        fun onLoadPlanetsSuccess(planets: List<Planet>?, nextPage: Int?)
        fun onLoadPlanetsError()
    }

    fun getPlanets(onLoadPlanets: onLoadPlanets, page: Int) {
        RetrofitClient.service.getPlanets(page).enqueue(object : Callback<PlanetsResponse> {
            override fun onFailure(call: Call<PlanetsResponse>, t: Throwable) {
                onLoadPlanets.onLoadPlanetsError()
            }

            override fun onResponse(call: Call<PlanetsResponse>, response: Response<PlanetsResponse>) {
                var nextPage: Int? = null
                if(response.body()?.next != null) {
                    nextPage = Uri.parse(response.body()?.next).getQueryParameter("page")?.toInt()
                }
                onLoadPlanets.onLoadPlanetsSuccess(response.body()?.results, nextPage)
            }
        })
    }
}