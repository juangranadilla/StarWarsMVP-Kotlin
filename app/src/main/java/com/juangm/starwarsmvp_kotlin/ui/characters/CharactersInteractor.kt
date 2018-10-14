package com.juangm.starwarsmvp_kotlin.ui.characters

import android.net.Uri
import com.juangm.starwarsmvp_kotlin.data.models.Character
import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersInteractor {

    interface onLoadCharacters {
        fun onLoadCharactersSuccess(characters: List<Character>?, nextPage: Int?)
        fun onLoadCharactersError()
    }

    fun getCharacters(onLoadCharacters: onLoadCharacters, page: Int) {
        RetrofitClient.service.getCharacters(page).enqueue(object : Callback<CharactersResponse> {
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                onLoadCharacters.onLoadCharactersError()
            }

            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                var nextPage: Int? = null
                if(response.body()?.next != null) {
                    nextPage = Uri.parse(response.body()?.next).getQueryParameter("page")?.toInt()
                }
                onLoadCharacters.onLoadCharactersSuccess(response.body()?.results, nextPage)
            }
        })
    }
}