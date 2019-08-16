package com.sundaymobility.network.apis

import com.sundaymobility.network.responsepojo.UserData
import com.sundaymobility.utility.Constants
import retrofit2.http.GET
import rx.Observable

interface APIServiceInterface {
    @GET(Constants.BASE_URL + "users")
    fun getAllUserData(): Observable<UserData>
}