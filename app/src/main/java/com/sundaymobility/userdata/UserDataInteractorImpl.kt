package com.sundaymobility.userdata

import com.sundaymobility.network.APISuccess
import com.sundaymobility.network.Api
import com.sundaymobility.network.responsepojo.UserData
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class UserDataInteractorImpl : UseDataInteractor {
    override fun getUserData(interfaceInteractor: InterfaceInteractor) {
        Api.apiServiceInterface()
            .getAllUserData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APISuccess<UserData>(){
                override fun call(t: UserData?) {

                       println("username : ${t?.login}")
                }

            })

    }

}