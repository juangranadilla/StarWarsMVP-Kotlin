package com.juangm.starwarsmvp_kotlin.data.network

import com.juangm.starwarsmvp_kotlin.data.network.response.CharactersResponse
import com.juangm.starwarsmvp_kotlin.data.network.response.PlanetsResponse
import com.juangm.starwarsmvp_kotlin.data.network.response.StarshipsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * Retrieve a list of planets
     */
    @GET("planets/")
    fun getPlanets(@Query("page") page: Int): Call<PlanetsResponse>

    /**
     * Retrieve a list of characters
     */
    @GET("people/")
    fun getCharacters(@Query("page") page: Int): Call<CharactersResponse>

    /**
     * Retrieve a list of starships
     */
    @GET("starships/")
    fun getStarships(@Query("page") page: Int): Call<StarshipsResponse>
}