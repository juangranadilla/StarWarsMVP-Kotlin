package com.juangm.starwarsmvp_kotlin.ui.starships

import android.net.Uri
import com.juangm.starwarsmvp_kotlin.data.models.Starship
import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.StarshipsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipsInteractor {

    interface onLoadStarships {
        fun onLoadStarshipsSuccess(starships: List<Starship>?, nextPage: Int?)
        fun onLoadStarshipsError()
    }

    fun getStarships(onLoadStarships: onLoadStarships, page: Int) {
        RetrofitClient.service.getStarships(page).enqueue(object : Callback<StarshipsResponse> {
            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
                onLoadStarships.onLoadStarshipsError()
            }

            override fun onResponse(call: Call<StarshipsResponse>, response: Response<StarshipsResponse>) {
                var nextPage: Int? = null
                if(response.body()?.next != null) {
                    nextPage = Uri.parse(response.body()?.next).getQueryParameter("page")?.toInt()
                }
                onLoadStarships.onLoadStarshipsSuccess(response.body()?.results, nextPage)
            }
        })
    }
}