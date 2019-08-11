package com.sundaymobility.network.apis

import com.sundaymobility.network.responsepojo.UserData
import io.reactivex.Observable
import retrofit2.http.GET

interface APIServiceInterface {
    @GET("users")
    fun getAllUserData(): Observable<List<UserData>>
}