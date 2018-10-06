package com.juangm.starwarsmvp_kotlin.data.network

import com.juangm.starwarsmvp_kotlin.data.network.response.CharactersResponse
import com.juangm.starwarsmvp_kotlin.data.network.response.PlanetsResponse
import com.juangm.starwarsmvp_kotlin.data.network.response.StarshipsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    /**
     * Retrieve a list of planets
     */
    @GET("planets/")
    fun getPlanets(): Call<PlanetsResponse>

    /**
     * Retrieve a list of people
     */
    @GET("people/")
    fun getPeople(): Call<CharactersResponse>

    /**
     * Retrieve a list of starships
     */
    @GET("starships/")
    fun getStarships(): Call<StarshipsResponse>
}