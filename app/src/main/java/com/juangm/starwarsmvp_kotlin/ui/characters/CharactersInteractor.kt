package com.juangm.starwarsmvp_kotlin.ui.characters

import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersInteractor {

    interface onLoadCharacters {
        fun onLoadCharactersSuccess()
        fun onLoadCharactersError()
    }

    fun getCharacters(onLoadCharacters: onLoadCharacters) {
        RetrofitClient.service.getCharacters().enqueue(object : Callback<CharactersResponse> {
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                onLoadCharacters.onLoadCharactersError()
            }

            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                onLoadCharacters.onLoadCharactersSuccess()
            }
        })
    }
}