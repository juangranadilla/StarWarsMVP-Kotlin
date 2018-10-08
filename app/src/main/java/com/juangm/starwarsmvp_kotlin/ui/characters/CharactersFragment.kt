package com.juangm.starwarsmvp_kotlin.ui.characters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R

class CharactersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_planets, container, false)

//        doAsync {
//            RetrofitClient.service.getCharacters().enqueue(object : Callback<CharactersResponse> {
//                override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
//                    uiThread {
//                        toast("Failure!")
//                    }
//                }
//
//                override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
//                    uiThread {
//                        toast("Success!")
//                    }
//                }
//            })
//        }

        return view
    }
}
