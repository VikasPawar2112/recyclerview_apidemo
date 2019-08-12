package com.sundaymobility.network

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun success(message: String)

    fun fail(message: String)

    fun noInternet()
}