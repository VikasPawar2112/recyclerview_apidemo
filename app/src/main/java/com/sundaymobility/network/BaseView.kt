package com.sundaymobility.network

import com.hannesdorfmann.mosby.mvp.MvpView

interface BaseView : MvpView {
    fun showLoading()

    fun hideLoading()

    fun success(message: String)

    fun fail(message: String)

    fun noInternet()
}