package com.juangm.starwarsmvp_kotlin.ui.common

interface BaseView {
    fun showProgress()
    fun hideProgress()
    fun showProgressLoadMore()
    fun hideProgressLoadMore()
    fun showError()
}