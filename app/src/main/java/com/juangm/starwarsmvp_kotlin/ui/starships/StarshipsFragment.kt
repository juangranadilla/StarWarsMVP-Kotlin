package com.juangm.starwarsmvp_kotlin.ui.starships

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juangm.starwarsmvp_kotlin.R

class StarshipsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_starships, container, false)

//        doAsync {
//            RetrofitClient.service.getStarships().enqueue(object : Callback<StarshipsResponse> {
//                override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
//                    uiThread {
//                        toast("Failure!")
//                    }
//                }
//
//                override fun onResponse(call: Call<StarshipsResponse>, response: Response<StarshipsResponse>) {
//                    uiThread {
//                        toast("Success!")
//                    }
//                }
//            })
//        }

        return view
    }
}
