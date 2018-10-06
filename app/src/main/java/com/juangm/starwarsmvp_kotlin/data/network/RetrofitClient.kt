package com.juangm.starwarsmvp_kotlin.data.network

import com.juangm.starwarsmvp_kotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val BASE_URL = "http://swapi.co/api/"

    val service: ApiService by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    private fun getOkHttpClient() : OkHttpClient {
        return OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                })
                .build()
    }
}