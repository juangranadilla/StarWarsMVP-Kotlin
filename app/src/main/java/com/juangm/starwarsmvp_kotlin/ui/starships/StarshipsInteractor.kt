package com.juangm.starwarsmvp_kotlin.ui.starships

import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.StarshipsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipsInteractor {

    interface onLoadStarships {
        fun onLoadStarshipsSuccess()
        fun onLoadStarshipsError()
    }

    fun getStarships(onLoadStarships: onLoadStarships) {
        RetrofitClient.service.getStarships().enqueue(object : Callback<StarshipsResponse> {
            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
                onLoadStarships.onLoadStarshipsError()
            }

            override fun onResponse(call: Call<StarshipsResponse>, response: Response<StarshipsResponse>) {
                onLoadStarships.onLoadStarshipsSuccess()
            }
        })
    }
}