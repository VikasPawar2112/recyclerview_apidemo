package com.sundaymobility.network

import com.hannesdorfmann.mosby.mvp.MvpView

interface BaseView : MvpView {
    fun showLoading()

    fun hideLoading()

    fun fail(message: String)

    fun noInternet()
}