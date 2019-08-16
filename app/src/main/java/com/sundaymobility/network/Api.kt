package com.sundaymobility.network

import java.util.concurrent.TimeUnit

import com.sundaymobility.network.apis.APIServiceInterface
import com.sundaymobility.utility.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson


object Api {

    /* val BASEURL = "https://api.theshareapp.co"
     private var mHttpClient: OkHttpClient.Builder? = null
     private var mRetrofit: Retrofit? = null

     private val retrofit: Retrofit
         get() {
             val interceptor = HttpLoggingInterceptor()
             interceptor.level = HttpLoggingInterceptor.Level.BODY
             if (mHttpClient == null) {
                 mHttpClient = OkHttpClient.Builder()
             }
             mHttpClient!!.addInterceptor(interceptor)

             mHttpClient!!.connectTimeout(5, TimeUnit.MINUTES)
             mHttpClient!!.writeTimeout(5, TimeUnit.MINUTES)
             mHttpClient!!.readTimeout(5, TimeUnit.MINUTES)


             val client = mHttpClient!!.build()


             val mBuilder = Retrofit.Builder()
                 .baseUrl(Constants.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

             if (mRetrofit == null) {
                 mRetrofit = mBuilder.client(client).build()
             }

             return mRetrofit!!
         }*/

    fun getRetrofilt():Retrofit{
    val interceptor = HttpLoggingInterceptor()
    var client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    var gson = GsonBuilder()
        .setLenient()
        .create()
    var retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        return retrofit
    }

    fun apiServiceInterface(): APIServiceInterface {
        return getRetrofilt().create(APIServiceInterface::class.java)
    }
}
