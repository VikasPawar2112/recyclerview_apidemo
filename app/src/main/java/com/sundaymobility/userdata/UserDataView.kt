package com.sundaymobility.userdata

import com.sundaymobility.network.BaseView
import com.sundaymobility.network.responsepojo.UserData

interface UserDataView : BaseView{

    fun loadUserData(userDataList : MutableList<UserData>)
}