package com.sundaymobility.userdata

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

class UserDataPresenterImpl(var view: UserDataView?) :
    MvpBasePresenter<UserDataView>(),
    UserDataPresenter,
    InterfaceInteractor {

    var interactor: UseDataInteractor = UserDataInteractorImpl()

    override fun getUserData() {
        if (view != null) {
//            view?.showLoading()
            interactor.getUserData(this)
        }
    }

    override fun successApi() {
    }

    override fun failApi(message: String) {
    }

    override fun noInternet() {
    }

    override fun onDestroyClass() {
        view = null
    }


}