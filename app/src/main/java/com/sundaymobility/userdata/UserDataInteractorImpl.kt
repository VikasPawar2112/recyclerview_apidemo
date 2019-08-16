package com.sundaymobility.userdata

import com.sundaymobility.network.APISuccess
import com.sundaymobility.network.ApiClient
import com.sundaymobility.network.ApiFail
import com.sundaymobility.network.HttpErrorResponse
import com.sundaymobility.network.responsepojo.UserData
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class UserDataInteractorImpl : UseDataInteractor {
    override fun getUserData(onQueryFinishListnerGetUserData: UseDataInteractor.OnQueryFinishListnerGetUserData) {
        ApiClient.apiServiceInterface()
            .getAllUserData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APISuccess<MutableList<UserData>>() {
                override fun call(userDataList: MutableList<UserData>?) {
                    onQueryFinishListnerGetUserData.onSuccessGetUserData(userDataList!!)
                }

            }, object : ApiFail() {
                override fun httpStatus(response: HttpErrorResponse) {
                    onQueryFinishListnerGetUserData.failApi(response.error)
                }

                override fun noNetworkError() {
                    onQueryFinishListnerGetUserData.noInternet()
                }

                override fun unknownError(e: Throwable?) {
                    onQueryFinishListnerGetUserData.failApi(e?.message ?: "api fail unknown error")
                }

            })
    }

}