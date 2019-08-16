package com.sundaymobility.network

import com.sundaymobility.network.apis.APIServiceInterface
import com.sundaymobility.utility.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getApiClient(baseUrl : String): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    fun apiServiceInterface(baseUrl : String): APIServiceInterface {
        return getApiClient(baseUrl)!!.create(APIServiceInterface::class.java)
    }
}