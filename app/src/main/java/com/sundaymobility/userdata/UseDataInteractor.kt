package com.sundaymobility.userdata

import com.sundaymobility.network.responsepojo.UserData

interface UseDataInteractor {

    interface OnQueryFinishListnerGetUserData : InterfaceInteractor{
        fun onSuccessGetUserData(userDataList : MutableList<UserData>)
    }
    fun getUserData(onQueryFinishListnerGetUserData: OnQueryFinishListnerGetUserData )
}