package com.juangm.starwarsmvp_kotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.juangm.starwarsmvp_kotlin.R
import com.juangm.starwarsmvp_kotlin.data.network.RetrofitClient
import com.juangm.starwarsmvp_kotlin.data.network.response.CharactersResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {
            RetrofitClient.service.getPeople().enqueue(object : Callback<CharactersResponse> {
                override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                    uiThread {
                        toast("Failure!")
                    }
                }

                override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                    uiThread {
                        toast("Success!")
                    }
                }
            })
        }
    }
}