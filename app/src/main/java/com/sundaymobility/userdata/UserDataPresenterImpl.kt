package com.sundaymobility.userdata

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.sundaymobility.network.responsepojo.UserData

class UserDataPresenterImpl(var view: UserDataView?) :
    MvpBasePresenter<UserDataView>(),
    UserDataPresenter,
    UseDataInteractor.OnQueryFinishListnerGetUserData {

    var interactor: UseDataInteractor = UserDataInteractorImpl()

    override fun getUserData() {
        if (view != null) {
            view?.showLoading()
            interactor.getUserData(this)
        }
    }

    override fun onSuccessGetUserData(userDataList: MutableList<UserData>) {
        if (view != null) {
            view?.hideLoading()
            view?.loadUserData(userDataList)
        }
    }

    override fun failApi(message: String) {
        if (view != null) {
            view?.hideLoading()
            view?.fail(message)
        }
    }

    override fun noInternet() {
        if (view != null) {
            view?.hideLoading()
            view?.noInternet()
        }
    }

    override fun onDestroyClass() {
        view = null
    }
}